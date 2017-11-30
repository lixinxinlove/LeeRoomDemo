#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_lixinxin_leeroomdemo_jni_JNIS_stringFromJNI(JNIEnv *env, jobject instance) {


    char *returnValue = "leee";

    return (*env)->NewStringUTF(env, returnValue);
}

JNIEXPORT jstring JNICALL
Java_com_lixinxin_leeroomdemo_jni_JNIS_stringLee(JNIEnv *env, jobject instance, jstring string_) {
    const char *string = (*env)->GetStringUTFChars(env, string_, 0);

    // TODO

    (*env)->ReleaseStringUTFChars(env, string_, string);

    char *returnValue = "leee";

    return (*env)->NewStringUTF(env, returnValue);
}