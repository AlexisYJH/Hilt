package com.example.hilt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.android.scopes.ActivityScoped;

/**
 * @author AlexisYin
 */
@InstallIn(ActivityComponent.class)
//2. 建立绑定：第二种方式：去除构造方法的@Inject注解，创建Module，装载到组件
//ApplicationComponent组件实例在Application#onCreate创建，在Application#onDestroy销毁
//@InstallIn(ApplicationComponent.class)
@Module
public class AppModule {

    /**
     * 由于ApplicationComponent的作用域为@Singleton，所以该方法要么不加作用域，要么只能使用@Singleton
     * 不加作用域：user != user2
     * 使用@Singleton： user == user2
     */
    //@Singleton

    /**
     * 使用@ActivityScoped，装载到ActivityComponent，组件实例在Activity#onCreate创建，在Activity#onDestroy销毁
     * user == user2 != user3
     */
    //@ActivityScoped
    @Provides
    User providerUser() {
        return new User();
    }

    /**
     * 注释构造方法的@Inject注解，使用模块提供，报错
     * 因为ApplicationComponent只默认绑定了Application，没有Activity
     * 改为ActivityComponent，默认绑定Application和Activity
     * <p>
     * context需要添加限定符，否则报错
     * 预定义的限定符(Qualifier): @ApplicationContext和@ActivityContext
     * 限定符：支持同一个对象不同实例获取方式
     */
    @Provides
    ViewModel providerViewModel(User user, Application application, Activity activity,
//                                @ApplicationContext Context context) {
                                @ActivityContext Context context) {
        return new ViewModel(user, application, activity, context);
    }
}
