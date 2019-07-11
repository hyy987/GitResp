package com.mall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample4 {

    private final static int threadCount=20;
    public static void main(String[] args) throws InterruptedException {

        //声明线程池调度多个线程
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore  semaphore = new Semaphore(3);//允许的并发数
        for(int i =0;i<threadCount;i++){
            final int threadNum = i;
            exec.execute(()->{
                try{

                    if(semaphore.tryAcquire(5000,TimeUnit.MILLISECONDS)){//尝试获取一个许可
                        test(threadNum);
                        semaphore.release();//释放一个许可
                    }
                }catch (Exception e){
                    log.info("exception",e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }
    private static void test(int threadNum) throws InterruptedException {

        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
