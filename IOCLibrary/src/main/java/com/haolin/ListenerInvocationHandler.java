package com.haolin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 作者：haoLin_Lee on 2019/05/08 17:41
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class ListenerInvocationHandler implements InvocationHandler {

    private Object target;//需要拦截的对象 比如activity fragment
    private HashMap<String, Method> map = new HashMap<>();

    ListenerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        method = map.get(method.getName());
        if (method!=null){
           return method.invoke(target,objects);
        }
        return null;
    }

    /**
     * 添加拦截方法
     *
     * @param methodName 本应该执行的onClick方法 进行拦截
     * @param method     去执行开发者自定义的方法
     */
    public void addMethod(String methodName, Method method) {
        map.put(methodName, method);
    }
}
