package com.atguigu.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.atguigu.java8.Employee;

public class TestLambda {

	public static void main(String[] args) {
		test1();
	}
	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99), 
			new Employee("李四", 38, 5555.99),
			new Employee("王五", 58, 3333.99),
			new Employee("赵六", 16, 2222.99),
			new Employee("沈七", 8, 8888.99));
	public static void test1() {
		Collections.sort(employees, (e1,e2)->{
			if(e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for(Employee e:employees) {
			System.out.println(e);
		}
	}
}
