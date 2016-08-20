package com.laotse.loader.ClassLoader;

import com.laotse.example.IUser;

import java.lang.reflect.Method;

/**
 * 这种方式会冲突
 * Created by Administrator on 2016/8/20.
 */
public class RunLoader {
    public static void main(String[] args) throws Exception {
        FirstLoader loader1 = new FirstLoader("loader1");
        loader1.setPath("D:\\GitHub\\java\\classloader\\hello1\\target\\classes\\com\\laotse\\example");
        Class<?> clazz1 = loader1.loadClass("com.laotse.example.User");
//        IUser iUser1 = (IUser) clazz1.newInstance();
//        iUser1.sayHello("Lily");
        Method sayHello1 = clazz1.getDeclaredMethod("sayHello", String.class);
        sayHello1.invoke(clazz1.newInstance(), "Lily");

        SencondLoader loader2 = new SencondLoader("loader2");
        loader2.setPath("D:\\GitHub\\java\\classloader\\hello2\\target\\classes\\com\\laotse\\example");
        Class<?> clazz2 = loader2.loadClass("com.laotse.example.User");
//        IUser iUser2 = (IUser) clazz2.newInstance();
//        iUser2.sayHello("Lily");
        Method sayHello2 = clazz2.getDeclaredMethod("sayHello", String.class);
        sayHello2.invoke(clazz2.newInstance(), "Lily");
    }
}
