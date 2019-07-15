package com.mall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample3 {
    public static void main(String[] args){
        //单线程化线程池，唯一工作线程执行任务
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
