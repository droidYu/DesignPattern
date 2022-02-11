package com.droidyu.designpattern.singleton._3;
/**
 懒汉式（线程安全）
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
