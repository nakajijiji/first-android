package com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.ScrollActivity;
import com.example.mayuhei.helloworld.SubActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        EditText input = (EditText) findViewById(R.id.editText);
        String text = input.getText().toString();
        TextView mainText = (TextView) findViewById(R.id.textView2);
        mainText.setText(text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void toScroll(View view){
        Intent intent = new Intent(getApplication(), ScrollActivity.class);
        startActivity(intent);
    }

    public void toRealScroll(View view){
        Intent intent = new Intent(getApplication(), RealScroll.class);
        startActivity(intent);
    }

    public void move(View view) {
        Intent intent = new Intent(getApplication(), SubActivity.class);
        startActivity(intent);
    }
}
