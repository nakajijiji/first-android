package com.example.mayuhei.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;

import java.util.ArrayList;
import java.util.List;

public class ScrollActivity extends AppCompatActivity {
    private GestureDetector detector;
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        detector = new GestureDetector(this, listener);
        initializeViews();
    }

    private void initializeViews(){
        views.add(findViewById(R.id.radioButton));
        views.add(findViewById(R.id.radioButton2));
        views.add(findViewById(R.id.radioButton3));
        views.add(findViewById(R.id.radioButton4));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return detector.onTouchEvent(event);
    }

    private final GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e1.getX() - e2.getX();
            for(View v : views){
                Log.e("hoge", "fuga" + distanceX);
                v.setX(v.getX() - distanceX);
            }
            return true;
        }
    };
}
