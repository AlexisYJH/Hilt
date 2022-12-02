package com.example.hilt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

//4. 注入目标类添加@AndroidEntryPoint注解
// 代替Dagger2中DaggerApplicationComponent.create().inject(this);
// 注入的Activity必须是ComponentActivity的子类
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    //3. 在注入目标类中声明依赖项，加上@Inject注解
    @Inject
    User user, user2;

    @Inject
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "MainActivity.getSuperclass : " + this.getClass().getSuperclass().getSimpleName());
        Log.d("TAG", "user: " + user);
        Log.d("TAG", "user2: " + user2);
        startActivity(new Intent(this, SecondActivity.class));

        //viewModel.test();

        //Hilt支持ViewModel-3. 创建MainViewModel实例
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.test();
    }
}