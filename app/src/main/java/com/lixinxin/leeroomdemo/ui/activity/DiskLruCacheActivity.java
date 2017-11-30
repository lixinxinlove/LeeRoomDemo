package com.lixinxin.leeroomdemo.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lixinxin.leeroomdemo.R;
import com.lixinxin.leeroomdemo.cache.DiskLruCacheHelper;
import com.lixinxin.leeroomdemo.jni.JNIS;

import java.io.IOException;

public class DiskLruCacheActivity extends AppCompatActivity {

    private DiskLruCacheHelper mDiskLruCacheHelper;

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disk_lru_cache);

        textView=findViewById(R.id.tv);


        JNIS jnis=new JNIS();
        textView.setText(jnis.stringFromJNI());


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this ,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }else{
            try {
                mDiskLruCacheHelper = new DiskLruCacheHelper(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 100: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    try {
                        mDiskLruCacheHelper = new DiskLruCacheHelper(this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }

    }

    public void onSave(View view) {

        mDiskLruCacheHelper.put("key", "lixinxin");

    }

    public void onGet(View view) {
       String s=  mDiskLruCacheHelper.getAsString("key");
       textView.setText(s);
    }

}
