package com.laotse.loader.URLClassLoader;

import com.laotse.example.IUser;
import com.laotse.example.User;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * 参考http://www.cnblogs.com/flyingzl/articles/3139028.html
 * Created by Administrator on 2016/8/20.
 */
public class Main {
    public static void main(String[] args) {
        runTest("D:\\GitHub\\java\\classloader\\hello1\\target\\hello1-1.0-SNAPSHOT.jar");
        runTest("D:\\GitHub\\java\\classloader\\hello2\\target\\hello2-1.0-SNAPSHOT.jar");
    }

    private static void runTest(String jarPath){
        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);

        try {
            classLoader.addJar(new File(jarPath).toURI().toURL());
            Class<?> clazz = classLoader.loadClass("com.laotse.example.User");
            //Method method = clazz.getDeclaredMethod("sayHello");
            Method sayHello = clazz.getDeclaredMethod("sayHello", String.class);
            sayHello.invoke(clazz.newInstance(), "Lily");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
