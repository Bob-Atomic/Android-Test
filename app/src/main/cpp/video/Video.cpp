//
// Created by Bob on 2018/12/10.
//

#include <jni.h>
#include <string>
#include <android/log.h>

#include "Video.h"

int Video::getLegth() {
    int temp = length * 2;
    __android_log_print(ANDROID_LOG_DEBUG, TAG_VIDEO, "get video's lenth, the value is %d", temp);
    return temp;
}

void Video::setLength(int length) {
    int temp = length / 2;
    __android_log_print(ANDROID_LOG_DEBUG, TAG_VIDEO, "set video's lenth, the value is %d", temp);
    this->length = temp;
}

jint JNI_OnLoad(JavaVM* vm, void* reserved){
    JNIEnv* env;
    if(vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK){
        return -1;
    }

    /**
     * 添加自己需要注册的函数
     */

    return JNI_VERSION_1_6;

}

