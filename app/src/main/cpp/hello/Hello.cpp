//
// Created by Bob on 2018/12/17.
//

#include "Hello.h"

#include <jni.h>
#include <string>

#include <android/log.h>

int cal(int a, int b);

extern "C" JNIEXPORT jstring JNICALL
Java_com_test_bob_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";

    int a = cal(1, 0);

    __android_log_print(ANDROID_LOG_DEBUG, "Hello", "cal resuelt(1, 0) = %d", a);

    return env->NewStringUTF(hello.c_str());
}

int cal(int a, int b){
    asm(
            "udiv x0, x0, x1 \n\t"
            "ret"
    );

}