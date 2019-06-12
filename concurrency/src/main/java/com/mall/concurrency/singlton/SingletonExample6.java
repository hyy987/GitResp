package com.mall.concurrency.singlton;

import com.mall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式单例-》  双重同步锁
 * 构造函数私有化
 * 延时加载（单例的实例在第一个使用时实例化）
 */
@Slf4j
@ThreadSafe
public class SingletonExample6 {
    //私有构造函数
    private SingletonExample6() {
    }

    private  static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args){

        System.out.println(instance);
        System.out.println(instance);
    }
}
