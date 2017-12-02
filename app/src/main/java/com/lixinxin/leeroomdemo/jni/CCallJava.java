package com.lixinxin.leeroomdemo.jni;

import android.util.Log;

/**
 * Created by lixinxin on 2017/12/2.
 */

public class CCallJava {

    static {
        System.loadLibrary("CCallJava");
    }


    public native void callBack();

    public native int callBackForJni();


    public native int callJavaStatic();

    public int add(int x, int y) {
        int z = x + y;
        Log.e("CCallJava", "-----x+y=" + z);
        return z;
    }


    public static int getStringSize(String str) {
        Log.e("CCallJava", "字符串的长度是——>" + str.length());
        return str.length();
    }

}
