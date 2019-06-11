package com.mall.concurrency.singlton;

import com.mall.concurrency.annoations.NotRecommend;
import com.mall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式单例  双重同步锁
 * 构造函数私有化
 * 延时加载（单例的实例在第一个使用时实例化）
 */
@Slf4j
@ThreadSafe
public class SingletonExample4 {
    //私有构造函数
    private SingletonExample4() {
    }

    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static SingletonExample4 getInstance() {
        if (instance == null) {//双重检测机制
            synchronized (SingletonExample4.class) {//同步锁
                if (null == instance) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
