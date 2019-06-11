package com.mall.concurrency.singlton;

import com.mall.concurrency.annoations.NotThreadSafe;
import com.mall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式单例
 * 构造函数私有化（没有太多处理）
 * 非延时加载（类装载直接实例化类）
 * 线程安全
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {
    //私有构造函数
    private SingletonExample2() {
    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
