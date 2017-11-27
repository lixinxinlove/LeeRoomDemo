package com.lixinxin.leeroomdemo.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by lixinxin on 2017/11/27.
 */
@Entity
public class Food {

    @PrimaryKey
    private long id;
    private String name;
    private boolean eat;
    private int sum;
    private double price;
    @Ignore
    private String created;

    public Food() {
    }

    public Food(long id, String name, boolean eat, int sum, double price, String created) {
        this.id = id;
        this.name = name;
        this.eat = eat;
        this.sum = sum;
        this.price = price;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
