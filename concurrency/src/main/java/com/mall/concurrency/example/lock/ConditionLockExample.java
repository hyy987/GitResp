package com.mall.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionLockExample {
    public static void main(String[] args){
        ReentrantLock  reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        //线程1
        new Thread(()->{
           try{
               reentrantLock.lock();
               log.info("wait signal");//1
               condition.await();//锁的释放
           }catch (Exception e){
               e.printStackTrace();
           }
           log.info("get signal");//4
           reentrantLock.unlock();
        }).start();

        //线程2
        new Thread(()->{
            reentrantLock.lock();
            log.info("get lock");//2
            try{
                Thread.sleep(3000);
            }catch (Exception  e ){
                e.printStackTrace();
            }
            condition.signalAll();//发送信号
            log.info("send signal");//3
            reentrantLock.unlock();//释放锁
        }).start();
    }
}
