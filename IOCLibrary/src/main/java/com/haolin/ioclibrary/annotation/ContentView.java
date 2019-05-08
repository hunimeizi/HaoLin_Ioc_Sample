package com.haolin.ioclibrary.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：haoLin_Lee on 2019/05/08 16:19
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {

    int value();
}
