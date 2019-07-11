package com.mall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

    private final static int threadCount=200;
    public static void main(String[] args) throws InterruptedException {

        //声明线程池调度多个线程
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore  semaphore = new Semaphore(20);//允许的并发数
        for(int i =0;i<threadCount;i++){
            final int threadNum = i;
            exec.execute(()->{
                try{
                    semaphore.acquire(3);//获取多个许可
                    test(threadNum);
                    semaphore.release(3);//释放多个许可
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
        Thread.sleep(1);
    }
}
