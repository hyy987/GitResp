package com.mall.concurrency.example.threadLocal;

public class RequestHolder {
    private final static  ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    //存放数据
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
