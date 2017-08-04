package com.wugang.learning_record.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wugang.learning_record.R;
import com.wugang.learning_record.widget.SinkView;

/**
 * Created by wugang on 2017/8/4.
 */

public class ProgressActivity extends AppCompatActivity {

    private Thread mThread;
    private float mPercent;
    private SinkView mSinkView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_progress);
        mSinkView = (SinkView) findViewById(R.id.sink);

        mSinkView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                check();
            }
        });

        mPercent = 0.3f;
        mSinkView.setPercent(mPercent);
    }


    private void check() {
        //当进度条到100%时，重置初始百分比
        mThread = new Thread(new Runnable() {

            @Override
            public void run() {

                mPercent = 0;
                while (mPercent <= 1) {
                    mSinkView.setPercent(mPercent);
                    mPercent += 0.01f;
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当进度条到100%时，重置初始百分比
//                mPercent = 0.3f;
//                mSinkView.setPercent(mPercent);
            }
        });
        mThread.start();
    }
}
