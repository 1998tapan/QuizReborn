package com.example.quizreborn;

import com.example.quizreborn.MainActivity;

public class Questions {

    int mQuestion;
    boolean mAns;

    Questions(int Question, boolean Ans){
        mQuestion=Question;
        mAns=Ans;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean getAns() {
        return mAns;
    }

    public void setAns(boolean ans) {
        mAns = ans;
    }
}
