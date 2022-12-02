package com.example.hilt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * @author AlexisYin
 */
//已经绑定的类（其构造方法有@Inject注解）
public class ViewModel {

    //由自定义的模块提供创建
    User user;

    //预定义的绑定
    Application application;
    Activity activity;

    Context context;

//    @Inject
    public ViewModel(User user, Application application, Activity activity, Context context) {
        this.user = user;
        this.application = application;
        this.activity = activity;
        this.context = context;
    }

    public void test() {
        Log.d("TAG", "test user: " + user);
        Log.d("TAG", "test application: " + application);
        Log.d("TAG", "test activity: " + activity);
        Log.d("TAG", "test context: " + context);
    }
}
