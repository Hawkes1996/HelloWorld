package com.iissnan.android.geoquiz;

/**
 * Created by IIssNan on 2018/2/7 0007.
 */

public class Question {
    private int mTextResId;     //资源ID都为int型，在资源string.xml中为string型
    private boolean mAnswerTrue;

    public Question(int textResId,boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}

