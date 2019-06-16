package com.mall.concurrency.example.immutable;

import com.mall.concurrency.annoations.NotThreadSafe;

import java.util.HashMap;
import java.util.Map;

@NotThreadSafe
public class ImmutableExample {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a=2;
//        b="c";
//        map=new HashMap<>();
        map.put(1, 3);
        System.out.println(map.get(1));
    }

    private void test(final int a) {

//        a = 1;
    }
}
