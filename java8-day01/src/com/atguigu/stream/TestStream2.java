package com.atguigu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.atguigu.java8.Employee;
import com.atguigu.java8.Employee.Status;

/**
 * 一、Stream的三个操作步骤： 1.创建Stream 2.中间操作 3.终止操作（终端操作）
 * 
 *
 */
public class TestStream2 {

	public static void main(String[] args) {

//		test1();
//		test2();
//		test4();
//		test5();
		test6();
//		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
//
//		List list2= new ArrayList<>();
//		list2.add(11);
//		list2.addAll(list);
//		System.out.println(list2);
		/*System.out.println(employees);
		List<Employee> l1 = new ArrayList<>();
		Stream<Employee> map = employees.stream().map((e)->{
			if(e.getAge()>30) {
				e.setAge(88);
				return e;
			}else {
				e.setAge(8);
				return e;
			}
		});
		map.forEach(e->l1.add(e));
		System.out.println(l1);*/
	}

	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99,Status.BUSY), 
			new Employee("李四", 38, 5555.99,Status.FREE),
			new Employee("王五", 58, 3333.99,Status.VOCATION),
			new Employee("赵六", 16, 2222.99,Status.BUSY), 
			new Employee("沈七", 8, 8888.99,Status.VOCATION),
			new Employee("沈七", 8, 8888.99,Status.FREE),
			new Employee("沈七", 8, 8888.99,Status.BUSY));

	// 中间操作：不会执行任何操作
	
	/*
	 	筛选与切片
	 	filter——接收lambda，从流中排除某些元素
	 	limit——截断流，使其元素不超过给定数量
	 	skip——跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit互补
	 	distinct——筛选，通过流生成元素的hasncode()和equals()去除重复元素
	 */
	public static void test1() {
		Stream<Employee> stream = employees.stream()
		.filter((e) -> {
			System.out.println("Stream中间操作");
			return e.getAge() > 35;
			});
		//终止操作：一次性执行全部内容，即”惰性求值“
		stream.forEach(System.out::println);
	}

	//外被迭代：
	public static void test2() {

		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	//限制输出几个
	public static void test3() {
		employees.stream()
		.filter((e)->e.getSalay()>5000)
		.limit(2)
		.forEach(System.out::println);
	}

	//扔掉前几个跳过前面的
	public static void test4() {
		employees.stream()
		.filter((e)->e.getSalay()>5000)
		.skip(2)
		.distinct()
		.forEach(System.out::println);
	}

	/*
	 映射 
	 map
	 flatMap
	 */
	public static void test5() {

		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		
		list.stream().map((str)->str.toUpperCase())
		.forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		employees.stream()
		.map(Employee::getName)
		.forEach(System.out::println);
		
		System.out.println("------------------------------");

		Stream<Stream<Character>> stream = list.stream().map(TestStream2::filterChar);
		stream.forEach((sm)->{
			sm.forEach(System.out::println);
		});
		
		System.out.println("------------------------------");

		list.stream()
		.flatMap(TestStream2::filterChar)
		.forEach(System.out::println);
	}

	public static Stream<Character> filterChar(String str){
		List<Character> list = new ArrayList<>();
		for(Character c: str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}
	
	//排序
	/*
	 * sorted()——自然排序（Comparable）
	 * sorted(Comparator com)——定制排序（Comparator）
	 */
	public static void test6() {

		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		list.stream()
		.sorted().forEach(System.out::println);
		
		System.out.println("------------------------------");

		employees.stream()
		.sorted((e1,e2)->{
			if(new Integer(e1.getAge()).equals(e2.getAge())) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return new Integer(e1.getAge()).compareTo(e2.getAge());
			}
		}).forEach(System.out::println);
	}
}
