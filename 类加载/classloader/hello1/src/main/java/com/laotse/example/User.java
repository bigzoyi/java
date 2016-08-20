package com.laotse.example;

/**
 * Created by Administrator on 2016/8/20.
 */
public class User implements IUser  {
    public void sayHello(String name){
        System.out.println("Hello " + name + " the first!");
    }
}
