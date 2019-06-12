package com.mall.concurrency.singlton;

import com.mall.concurrency.annoations.Recommend;
import com.mall.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式：最安全的
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){}

    public static SingletonExample7 getInstance(){

        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
    public static void main(String[] args){

        System.out.println(SingletonExample7.getInstance());
        System.out.println(SingletonExample7.getInstance());
    }
}
