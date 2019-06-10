package com.example.quizreborn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";//for TAG constant in logs
    public static final String KEY_INDEX="index";
    TextView setquestion,uscore;
    Button true1,false1,next,prev;
    int mCurrentIndex=0,user_score=0;

    private  Questions[] mQuestionBank =  new Questions[]{
            new Questions(R.string.q1,false),
            new Questions(R.string.q2,false),
            new Questions(R.string.q3,true),
            new Questions(R.string.q4,false),
            new Questions(R.string.q5,true),
            new Questions(R.string.q6,true),
            new Questions(R.string.q7,false),
            new Questions(R.string.q8,true),
            new Questions(R.string.q9,false),
            new Questions(R.string.q10,true),
            new Questions(R.string.q11,false),
            new Questions(R.string.q12,true),
            new Questions(R.string.q13,true),
            new Questions(R.string.q14,false),
            new Questions(R.string.q15,false),
            new Questions(R.string.q16,true),
            new Questions(R.string.q17,true),
            new Questions(R.string.q18,true),
            new Questions(R.string.q19,false),
            new Questions(R.string.q20,false),
            new Questions(R.string.q1,false),
            new Questions(R.string.q1,false),
            new Questions(R.string.q1,false),
            new Questions(R.string.q1,false),
            new Questions(R.string.q1,false),
            new Questions(R.string.q1,false),
            new Questions(R.string.q1,false),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0;
        }

        setquestion=findViewById(R.id.setquestion);
        true1=findViewById(R.id.truebutton);
        false1=findViewById(R.id.falsebutton);
        next=findViewById(R.id.nextbutton);
        prev=findViewById(R.id.previousbutton);
        uscore=findViewById(R.id.score);

        int question=mQuestionBank[mCurrentIndex].getQuestion();
        setquestion.setText(question);
        uscore.setText(""+user_score);                //setText() takes int value as resource id, hence we need to convert it to String
                                                      //another way is setText(String.valueOf(user_score,   it works with giving a warning.

        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(true);
            }
        });

        false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(false);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNext();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePrev();
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();        //superclass implementation call
        Log.d(TAG,"onStart() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSavedInstance");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

    private void checkAns(boolean userPressed){
        boolean correct_ans=mQuestionBank[mCurrentIndex].getAns();
        int result_toast=0;
        if(userPressed==correct_ans){
            result_toast=R.string.True_Toast;
            user_score++;
            uscore.setText(""+user_score);
        }
        else{
            result_toast=R.string.False_Toast;
        }
        Toast.makeText(this,result_toast,Toast.LENGTH_SHORT).show();

    }

    private void updateNext(){
        mCurrentIndex=(mCurrentIndex + 1) % mQuestionBank.length;
        int question=(mQuestionBank[mCurrentIndex].getQuestion());
        setquestion.setText(question);
    }

    private void updatePrev(){
        if(mCurrentIndex==0){
            Toast.makeText(this,R.string.first_question, Toast.LENGTH_SHORT).show();
        }
        else {
            mCurrentIndex=(mCurrentIndex - 1) % mQuestionBank.length;
            int question = (mQuestionBank[mCurrentIndex].getQuestion());
            setquestion.setText(question);
        }
    }

}
