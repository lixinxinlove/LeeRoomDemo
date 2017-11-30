#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_lixinxin_leeroomdemo_jni_JNIS_stringFromJNI(JNIEnv *env, jobject instance) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());

}