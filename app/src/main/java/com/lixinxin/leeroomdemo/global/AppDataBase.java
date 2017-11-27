package com.lixinxin.leeroomdemo.global;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.lixinxin.leeroomdemo.dao.AnimalDao;
import com.lixinxin.leeroomdemo.dao.FoodDao;
import com.lixinxin.leeroomdemo.entity.Animal;
import com.lixinxin.leeroomdemo.entity.Food;


/**
 * Created by liangzhongtai on 2017/9/11.
 */
@Database(entities = {Animal.class, Food.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AnimalDao animalDao();
    public abstract FoodDao foodDao();
}
