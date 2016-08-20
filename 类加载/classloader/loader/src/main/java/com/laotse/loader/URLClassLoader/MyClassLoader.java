package com.laotse.loader.URLClassLoader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Administrator on 2016/8/20.
 */
public class MyClassLoader  extends URLClassLoader {
    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public void addJar(URL url) {
        this.addURL(url);
    }
}
