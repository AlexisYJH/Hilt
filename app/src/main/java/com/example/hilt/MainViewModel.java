package com.example.hilt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import dagger.hilt.android.qualifiers.ApplicationContext;

/**
 * @author AlexisYin
 */

/**
 * Hilt支持ViewModel-0. 添加依赖
 */
public class MainViewModel extends ViewModel {
    User user;
    Application application;
    Activity activity;
    Context context;

    //Hilt支持ViewModel-2. 添加@ViewModelInject注解
    @ViewModelInject
    public MainViewModel(User user, Application application, Activity activity, @ApplicationContext Context context) {
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
