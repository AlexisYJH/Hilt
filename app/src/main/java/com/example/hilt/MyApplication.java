package com.example.hilt;

import android.app.Application;
import android.util.Log;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.HiltAndroidApp;

/**
 * @author AlexisYin
 */
//1. @HiltAndroidApp注解
@HiltAndroidApp
public class MyApplication extends Application {

    /**
     * 生成代码
     * DaggerMyApplication_HiltComponents_ApplicationC
     * Hilt_MyApplication（Javassist动态字节码技术）
     * 验证2：在build\outputs\apk\debug\app-debug.apk的dex文件中找到MyApplication查看Byte Code，可以看到.super Lcom/example/hilt/Hilt_MyApplication
     * 结论：Hilt在编译后打包前修改了字节码文件
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //验证1：MyApplication.getSuperclass : Hilt_MyApplication
        Log.d("TAG", "MyApplication.getSuperclass : " + this.getClass().getSuperclass().getSimpleName());
    }

    /**
     * Hilt替换字节码内容
     * 0. 临时将plugin作为依赖项，方便查看代码，在右侧的External libs出现对应库
     * 1. 关键点：AndroidEntryPointClassTransformer#transformClass（搜索”Hilt_“）
     */
}
