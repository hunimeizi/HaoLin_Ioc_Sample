package com.haolin.ioc.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.haolin.IOCManager;

/**
 * 作者：haoLin_Lee on 2019/05/08 16:36
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IOCManager.inject(this);
    }
}
