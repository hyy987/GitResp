package com.mall.concurrency.example.immutable;

import com.mall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample2 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

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
