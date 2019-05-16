package com.atguigu.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestLambada {

	public static void main(String[] args) {

//		test07();
		test03();
		
	}

	// 原来的匿名内部类
	public void test01() {
		Comparator<Integer> com = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		TreeSet<Integer> ts = new TreeSet<>(com);
	}

	// Lambda表达式
	public void test02() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<>(com);
	}

	// 需求：获取当前公司中员工年龄大于35的员工信息
	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99), 
			new Employee("李四", 38, 5555.99),
			new Employee("王五", 58, 3333.99),
			new Employee("赵六", 16, 2222.99),
			new Employee("沈七", 8, 8888.99));
	
	//优化方式1:策略设计模式
	public static void test03() {
		MyPredicate<Employee> mp = new FilterByEmployeeAge();
		for(Employee e:employees) {
			if(mp.test(e)) {
				System.out.println(e);	
			}
		}
	}
	
	//优化方式2：匿名内部类
	
	public static void test04() {
		MyPredicate<Employee> mp = new MyPredicate<Employee>() {
			
			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.getAge()>=30;
			}
		};
		for(Employee e:employees) {
			if(mp.test(e)) {
				System.out.println(e);
			}
		}
	}
	
	//优化方式3：Lambda表达式
	public void test06() {
		
	}
	
	//优化方式4：
	public static void test07() {
		employees.stream()
		.filter((e)->e.getSalay()>=5000)
		.limit(2)
		.forEach(System.out::println);
		System.out.println("----------------------------");
		//提取对象属性
		employees.stream().map(Employee::getName)
		.forEach(System.out::println);
		
		
	}
}
