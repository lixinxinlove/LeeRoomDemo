package com.lixinxin.leeroomdemo.ui.activity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.lixinxin.leeroomdemo.MainActivity;
import com.lixinxin.leeroomdemo.R;
import com.lixinxin.leeroomdemo._interface.OnSizeChangedListener;
import com.lixinxin.leeroomdemo.view.MyScrollView;

public class WelcomeActivity extends AppCompatActivity {


    private MyScrollView myScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        initListener();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//            }
//        }, 6000);

    }


    private void initView() {
        myScrollView = findViewById(R.id.msv);
    }

    private void initListener() {
        myScrollView.setOnSizeChangedListener(new OnSizeChangedListener() {
            @Override
            public void onSizeChanged(int t, int oldt) {
                if (t - oldt > 0) {
                    Toast.makeText(WelcomeActivity.this, "向上", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WelcomeActivity.this, "向下", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
