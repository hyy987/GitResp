package com.mall.concurrency.singlton;

import com.mall.concurrency.annoations.NotRecommend;
import com.mall.concurrency.annoations.NotThreadSafe;
import com.mall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式单例
 * 构造函数私有化
 * 延时加载（单例的实例在第一个使用时实例化）
 * 影响性能
 */
@Slf4j
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    //私有构造函数
    private SingletonExample3(){}

    //单例对象
    private static SingletonExample3 instance =null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
