package com.wugang.learning_record.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wugang.learning_record.api.BlueService;
import com.wugang.learning_record.api.response.BookSearchResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wugang on 2017/8/16.
 */

public class RxJavaActivity extends AppCompatActivity {
    private static  final String TAG="RxJavaActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit
                        .Builder()
                        .baseUrl("https://api.douban.com/v2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                BlueService service = retrofit.create(BlueService.class);
                Call<BookSearchResponse> call = service.getSearchBooks("小王子", "", 0, 3);

                try {
                    BookSearchResponse response = call.execute().body();
                    Log.d(TAG,response.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
