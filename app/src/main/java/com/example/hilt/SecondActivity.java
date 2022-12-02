package com.example.hilt;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author AlexisYin
 */
@AndroidEntryPoint
public class SecondActivity extends AppCompatActivity {
    @Inject
    User user3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "user3: " + user3);
    }
}
