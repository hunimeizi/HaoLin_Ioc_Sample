package com.haolin.ioclibrary.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：haoLin_Lee on 2019/05/08 17:13
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ClickEventBase(listenerSetter = "setOnLongClickListener",listenerType = View.OnLongClickListener.class,callBackListener = "onLongClick")
public @interface OnLongClick {
    int[] value();
}
