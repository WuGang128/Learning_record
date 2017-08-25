package com.wugang.learning_record;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wugang.learning_record.activity.CoordinatorActivity;
import com.wugang.learning_record.activity.ProgressActivity;
import com.wugang.learning_record.activity.RxJavaActivity;
import com.wugang.learning_record.widget.BubbleView;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {
    private BubbleView bubbleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_sinkview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProgressActivity.class));
            }
        });
        findViewById(R.id.btn_coordinator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
            }
        });
        findViewById(R.id.btn_rxjava).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RxJavaActivity.class));
            }
        });
        bubbleView = (BubbleView) findViewById(R.id.BubbleView);
        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_indigo_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_deep_purple_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_cyan_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_blue_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_deep_purple_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_light_blue_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_lime_a200_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_pink_900_24dp));
        drawableList.add(getResources().getDrawable(R.drawable.ic_favorite_red_900_24dp));
        bubbleView.setDrawableList(drawableList);
        bubbleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bubbleView.startAnimation(bubbleView.getWidth(), bubbleView.getHeight());
            }
        });
    }

}
