//
// Created by lixinxin on 2017/12/2.
//

#include <jni.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_lixinxin_leeroomdemo_jni_JNIS_stringFromJNI(JNIEnv *env, jobject instance) {

   char *returnValue="Hello";

    return (*env)->NewStringUTF(env, returnValue);
}


JNIEXPORT jstring JNICALL
Java_com_lixinxin_leeroomdemo_jni_JNIS_stringLee(JNIEnv *env, jobject instance, jstring string_) {
     char *string = (*env)->GetStringUTFChars(env, string_, 0);

    char * returnValue=strcat(string,"jni string");

    return (*env)->NewStringUTF(env, returnValue);
}

