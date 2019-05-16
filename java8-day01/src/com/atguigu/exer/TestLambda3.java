package com.atguigu.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8内置四大核心函数式接口
 * @author admin
 * 
 * Consumer<T>:消费型接口
 * void accept(T t);
 * 
 * Supplier<T>:供给型接口
 * T get();
 * 
 * Function<T,R>:函数型接口
 * R apply(T t);
 * 
 * Predicate<T>:断原形接口
 * boolean test(T t);
 *
 */
public class TestLambda3 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	//Consumer<T>消费型接口：传参进行操作无返回值
	public static void test1() {
		happy(10000, (m)->System.out.println(("大宝剑")+m+"元"));
	}
	public static void happy(double money,Consumer<Double> con) {
		con.accept(money);
	}
	
	// Supplier<T>:供给型接口
	//需求：产生指定个数的整数，放到集合中
	public static List<Integer> getNumList(int num,Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for(int i =0;i<num;i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}
	
	public static void test2() {
		List<Integer> list = getNumList(10, ()->(int)(Math.random()*100));
		for(Integer num:list) {
			System.out.print(num+"\t");
		}
		System.out.println();
	}
	
	//Function<T,R>:函数型接口
	//需求：用于处理字符串
	public static String strHandler(String str,Function<String, String> fun) {
		return fun.apply(str);
	}
	
	public static void test3() {
		String strHandler = strHandler("\t\t\t回家睡大觉   ", (str)->str.trim());
		System.out.println(strHandler);
		
		System.out.println("--------------");
		String strHandler2 = strHandler("回家睡大觉", (str)->str.substring(0, 2));
		System.out.println(strHandler2);
	}
	
	//Predicate<T>:断原形接口
	//需求：将满足条件的字符串，放入集合中
	public static List<String> filterStr(List<String> strs,Predicate<String> p){
		List<String> newList = new ArrayList<>();
		for (String str : strs) {
			if(p.test(str)) {
				newList.add(str);
			}
		}
		return newList;
	}
	
	public static void test4() {
		List<String> list = Arrays.asList("aaaa","bbb","ccc","dddd","eeee","fff");
		List<String> filterStr = filterStr(list, (str)->str.length()<=3);
		for (String string : filterStr) {
			System.out.println(string);
		}
	}
}
