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
public class SingletonExample5 {
    //私有构造函数
    private SingletonExample5() {
    }

    //1.memory = allocate() 分配对象的内存空间
    //2.ctorInstance()初始化对象
    //3.instance=memory 设置instance指向刚分配的内存

    //JVM和CPU优化，发生了指令重排

    //1.memory = allocate() 分配对象的内存空间
    //3.instance=memory 设置instance指向刚分配的内存
    //2.ctorInstance()初始化对象
    //单例对象 volatile+双重检测机制-》禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) {//双重检测机制   //B-
            synchronized (SingletonExample5.class) {//同步锁
                if (null == instance) {
                    instance = new SingletonExample5();//A-3
                }
            }
        }
        return instance;
    }
}
