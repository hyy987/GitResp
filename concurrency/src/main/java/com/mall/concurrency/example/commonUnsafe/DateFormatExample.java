package com.mall.concurrency.example.commonUnsafe;

import com.mall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static com.mall.concurrency.example.commonUnsafe.StringExample1.stringBuilder;

@Slf4j
@NotThreadSafe
public class DateFormatExample {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    //请求总数
    public static int clientTotal=5000;
    //同时并发执行的线程数
    public static int threadTotal=200;


    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                //
                try{
                    //当前进程是否允许被执行
                    semaphore.acquire();
                    update();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void update(){
        try {
            simpleDateFormat.parse("20190617");
        } catch (ParseException e) {
          log.error("parse exception",e);
        }
    }
}
