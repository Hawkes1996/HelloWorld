package com.iissnan.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuziActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;  //定义当前的题号
    private static final String TAG = "QuziActivity";

    private void updateQuestion() {   //更新mQuestionTextView变量
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {  //判断答案正确与否
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called"); //日志输出
        setContentView(R.layout.activity_quzi);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);  //使用TextView
//        int question = mQuestionBank[mCurrentIndex].getTextResId();
//        mQuestionTextView.setText(question);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)%mQuestionBank.length;
                updateQuestion();
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);  //引用组件
        mTrueButton.setOnClickListener(new View.OnClickListener() {     //设置监听器
            @Override
            public void onClick(View view) {        //创建提示消息
                //Toast.makeText(QuziActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                //Does nothing yet,but soon!
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(QuziActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                //Does nothing yet,but soon!
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button); //下一题
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)%mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getTextResId();
//                mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        mPrevButton = (ImageButton) findViewById(R.id.prev_button);  //返回前一题
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex - 1)%mQuestionBank.length;
                int question = mQuestionBank[mCurrentIndex].getTextResId();
                mQuestionTextView.setText(question);
//                if(mCurrentIndex < 0){
//                  // Toast.makeText(this,R.string.prev_first,Toast.LENGTH_LONG).show();
//                }else{
//                    int question = mQuestionBank[mCurrentIndex].getTextResId();
//                    mQuestionTextView.setText(question);
//                }
            }
        });

        updateQuestion();
    }

    private Question[] mQuestionBank = new Question[] {    //创建Question对象数组
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_anericas,true),
            new Question(R.string.question_asia,true),
    };

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

//    @Override
//    public void onDestory() {
//        super.onDestroy();
//        Log.d(TAG,"onDestory() called");
//    }

}
