package com.lixinxin.leeroomdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lixinxin.leeroomdemo.dao.AnimalDao;
import com.lixinxin.leeroomdemo.entity.Animal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnSave, btnSelect;
    private TextView textView;


    AnimalDao animalDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initView();


        initData();


    }

    private void initData() {
        animalDao = App.db.animalDao();
    }

    private void initView() {

        textView = findViewById(R.id.tv);
        btnSave = findViewById(R.id.btn_save);
        btnSelect = findViewById(R.id.btn_select);

        btnSave.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
    }






    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                roomSave();
                break;
            case R.id.btn_select:
                roomSelect();
                break;
        }
    }

    private void roomSelect() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                final Animal animal = animalDao.queryUid(0)[0];

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(animal.toString());
                    }
                });


            }
        }).start();
    }

    private void roomSave() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Animal animal = new Animal();
                animal.aid = 0;
                animal.viviparity = true;
                animal.lifeTime = 10;
                animal.icon = "http://www.lee.com";
                animal.place = "lee";
                animalDao.insertAnimal(animal);

            }
        }).start();
    }
}
