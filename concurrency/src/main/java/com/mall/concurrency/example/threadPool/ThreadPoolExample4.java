package com.mall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args){
        //定常线程池，支持定时，周期性任务执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        for(int i=0;i<10;i++){
//            final int index =i;
//            scheduledExecutorService.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    log.info("task:{}",index);
//                }
//            },3, TimeUnit.SECONDS);
//            scheduledExecutorService.shutdown();

            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    log.warn("schedule run");
                }
            },1,3,TimeUnit.SECONDS);
//            scheduledExecutorService.shutdown();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    log.warn("timer run");
                }
            },new Date(),5*1000);
        }
}
