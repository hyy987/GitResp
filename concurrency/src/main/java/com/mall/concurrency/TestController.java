package com.mall.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Slf4j
public class TestController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    public static void main(String[] args){
//        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
//        listStream.flatMap(list->list.stream())
//                .forEach(System.out::println);

        Stream<String> stream = Stream.of("I", "love", "you", "too");
//        System.out.println(stream.reduce((s1,s2)->s1.length()>=s2.length()?s1:s2).get());
        Map<String, Integer> collect = stream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect);

        //使用toMap()统计学生GPA

    }
}
