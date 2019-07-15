package com.mall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample2 {
    public static void main(String[] args){
        //定常线程池，控制线程的最大并发数，超出会在队列中等待
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            final int index =i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task:{}",index);
                }
            });
        }
        executorService.shutdown();
    }
}
