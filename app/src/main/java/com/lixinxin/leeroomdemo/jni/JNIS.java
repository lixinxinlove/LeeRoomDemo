package com.lixinxin.leeroomdemo.jni;

/**
 * Created by lixinxin on 2017/11/30.
 */

public class JNIS {

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

}
