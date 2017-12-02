//
// Created by lixinxin on 2017/12/2.
//

#include <jni.h>

JNIEXPORT void JNICALL
Java_com_lixinxin_leeroomdemo_jni_CCallJava_callBack(JNIEnv *env, jobject instance) {


}

JNIEXPORT jint JNICALL
Java_com_lixinxin_leeroomdemo_jni_CCallJava_callBackForJni(JNIEnv *env, jobject instance) {

    //1.加载类 得到class 对象
    jclass jc = (*env)->FindClass(env, "com/lixinxin/leeroomdemo/jni/CCallJava");
    //2.得到对应方法的 Method 对象
    jmethodID jmethodID1 = (*env)->GetMethodID(env, jc, "add", "(II)I");
    //3.创建对象
    jobject jobject1 = (*env)->AllocObject(env, jc);
    //4.调用方法
    jint z = (*env)->CallIntMethod(env, jobject1, jmethodID1, 99, 1);

    return z;

}


JNIEXPORT jint JNICALL
Java_com_lixinxin_leeroomdemo_jni_CCallJava_callJavaStatic(JNIEnv *env, jobject instance) {

    //1.加载类 得到class 对象
    jclass jc = (*env)->FindClass(env, "com/lixinxin/leeroomdemo/jni/CCallJava");
    //2.得到对应方法的 Method 对象
    jmethodID jmethodID1 = (*env)->GetStaticMethodID(env, jc, "getStringSize", "(Ljava/lang/String;)I");
    //3.调用方法
    jstring str = (*env)->NewStringUTF(env, "lixinxin");
    jint z = (*env)->CallStaticIntMethod(env, jc,jmethodID1, str);

    return z;
}