package com.lixinxin.leeroomdemo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.lixinxin.leeroomdemo.entity.Food;

/**
 * Created by lixinxin on 2017/11/27.
 */
@Dao
public interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(Food... foods);

    @Delete
    void deleteFood(Food food);

    @Update
    void updataFood(Food food);

    @Query("SELECT * FROM Food WHERE id=:id")
    Food queryFood(long id);

}
