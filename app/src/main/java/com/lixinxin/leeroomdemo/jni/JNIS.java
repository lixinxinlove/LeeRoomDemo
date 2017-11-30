package com.lixinxin.leeroomdemo.jni;

/**
 * Created by lixinxin on 2017/11/30.
 */

public class JNIS {

    static {
        System.loadLibrary("Hello");
    }

    public native String stringFromJNI();

    public native String stringLee(String string);

}
