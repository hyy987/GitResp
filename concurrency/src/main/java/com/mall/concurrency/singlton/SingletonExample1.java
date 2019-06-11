package com.mall.concurrency.singlton;

import com.mall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式单例
 * 构造函数私有化
 * 延时加载（单例的实例在第一个使用时实例化）
 * 线程不安全
 */
@Slf4j
@NotThreadSafe
public class SingletonExample1 {
    //私有构造函数
    private SingletonExample1(){}

    //单例对象
    private static SingletonExample1 instance =null;

    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
