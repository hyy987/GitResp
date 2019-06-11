package com.mall.concurrency.example.AtomicExample;

import com.mall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicExample4 {

    //定义Atomic实例
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args){
        count.compareAndSet(0,2);//count=2
        count.compareAndSet(0,1);//no
        count.compareAndSet(1,3);//no
        count.compareAndSet(2,4);//count=4
        count.compareAndSet(3,5);//no
        log.info("Count:{}",count.get());

    }
}
