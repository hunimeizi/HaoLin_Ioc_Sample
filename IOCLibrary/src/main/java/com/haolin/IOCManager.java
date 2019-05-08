package com.haolin;

import android.app.Activity;
import android.view.View;

import com.haolin.ioclibrary.annotation.ClickEventBase;
import com.haolin.ioclibrary.annotation.ContentView;
import com.haolin.ioclibrary.annotation.InjectView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 作者：haoLin_Lee on 2019/05/08 16:26
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class IOCManager {

    public static void inject(Activity activity) {
        //布局注入
        injectLayout(activity);
        // 属性 赋值
        injectViews(activity);
        // 事件 长按点击
        injectEvents(activity);
    }


    /**
     * 布局注入
     *
     * @param activity activity
     */
    private static void injectLayout(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView != null) {
            int layoutId = contentView.value();
            //第一种方式
//            activity.setContentView(layoutId);
            //第二种方式 反射
//            clazz.getDeclaredMethod() //该方法是该activity是否集成父类，当前类以及父类的方法
            try {
                Method setContentView = clazz.getMethod("setContentView", int.class);//当前类的方法
                setContentView.invoke(activity, layoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 加载属性id
     * findViewById() 有返回值
     *
     * @param activity act
     */
    private static void injectViews(Activity activity) {

        Class<? extends Activity> clazz = activity.getClass();
        //获取类的所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field filed : fields) {
            InjectView injectView = filed.getAnnotation(InjectView.class);
            if (injectView != null) {
                int viewId = injectView.value();
                //第一种方式
//                activity.findViewById(viweId);
                //第二种方式 反射
                try {
                    Method findViewById = clazz.getMethod("findViewById", int.class);
                    Object view = findViewById.invoke(activity, viewId);
                    filed.setAccessible(true);//设置访问权限 private
                    filed.set(activity, view); //属性的值赋值给控件 在当前的类里
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //事件注入
    private static void injectEvents(Activity activity) {

        Class<? extends Activity> clazz = activity.getClass();
        //获取类的所有方法
        Method[] methos = clazz.getDeclaredMethods();
        for (Method method : methos) {//开发者定义的方法
            //拿到每个方法的所有注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                //事件的三个重要成员
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (annotationType != null) {
                    ClickEventBase clickEventBase = annotationType.getAnnotation(ClickEventBase.class);
                    if (clickEventBase != null) {
                        String listenerSetter = clickEventBase.listenerSetter();
                        // 执行的回调方法
                        String callBackListener = clickEventBase.callBackListener();
                        Class<?> listenerType = clickEventBase.listenerType();

                        try {
                            //通过annotationType获取onClick注解的value方法
                            Method valueMethod = annotationType.getDeclaredMethod("value");
                            //执行value方法 获取注解的值
                            int[] viewIds = (int[]) valueMethod.invoke(annotation);
                            //AOP 切面
                            ListenerInvocationHandler handler = new ListenerInvocationHandler(activity);
                                handler.addMethod(callBackListener,method);
                            //代理
                            Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class[]{listenerType}, handler);
                            for (int viewId : viewIds) {
                                View view = activity.findViewById(viewId);
                                //获取指定的方法 不如 setxxxlistenter()
                                Method setter = view.getClass().getMethod(listenerSetter, listenerType);
                                setter.invoke(view,listener);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
