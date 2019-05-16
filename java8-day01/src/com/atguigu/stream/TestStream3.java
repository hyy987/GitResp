package com.atguigu.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.atguigu.java8.Employee;
import com.atguigu.java8.Employee.Status;

public class TestStream3 {

	/**
	 * 查找与匹配
	 * 
	 */
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test7();
//		test8();
//		test9();
		test10();
		
		
	}

	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99, Status.BUSY),
			new Employee("李四", 38, 5555.99, Status.FREE), 
			new Employee("王五", 58, 3333.99, Status.VOCATION),
			new Employee("赵六", 16, 2222.99, Status.FREE),
			new Employee("赵六", 16, 2222.99, Status.FREE),
			new Employee("沈七", 8, 8888.99, Status.VOCATION));

	public static void test1() {
		boolean b = employees.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b);
		System.out.println("-------------");

		boolean c = employees.stream().anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(c);
		System.out.println("-------------");

		boolean d = employees.stream().noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(d);

		System.out.println("-------------");
		Optional<Employee> op = employees.stream()
				.sorted((e1, e2) -> Double.compare(e1.getSalay(), e2.getSalay()))
				.findFirst();
		System.out.println(op.get());

		System.out.println("-------------+++++++++");
		// stream()串行流
		// parallelStream()并行流
		Optional<Employee> op1 = employees.parallelStream().filter((e) -> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(op1.get());
	}

	public static void test2() {
		long count = employees.stream().count();
		System.out.println(count);

		System.out.println(employees.stream().max((e1, e2) -> Double.compare(e1.getSalay(), e2.getSalay())).get());

		Optional<Double> min = employees.stream()
				.map(Employee::getSalay)
				.min(Double::compare);
		System.out.println(min.get());

		employees.stream().forEach((e) -> {
			if (e.getSalay() > 5000) {
				System.out.println(e);
			}
		});
	}

	// 规约——————将流中元素反复结合起来，得到一个值
	public static void test3() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Integer sum = list.stream()
				.reduce(0, (x, y) -> x + y);
		System.out.println(sum);
		System.out.println("------------------");
		
		Optional<Double> reduce = employees.stream()
		.map((e)->e.getSalay())
		.reduce(Double::sum);
		System.out.println(reduce.get());
	}
	
	//收集
	//collect——将流转换为其他形式。接收一个Collector接口实现
	public static void test4() {

		List<String> list = employees.stream()
		.map((e)->e.getName())
		.collect(Collectors.toList());
		System.out.println(list);
		
		System.out.println("---------------");
		HashSet<String> s1 = employees.stream()
		.map(Employee::getName)
		.collect(Collectors.toCollection(HashSet::new));
		System.out.println(s1);
		
		System.out.println("---------------");
		Set<String> set = employees.stream()
		.map(Employee::getName)
		.collect(Collectors.toSet());
		System.out.println(set);
	}

	public static void test5() {

		//总数
		Long collect = employees.stream()
		.collect(Collectors.counting());
		System.out.println(collect);
		
		//平均值
		Double double1 = employees.stream()
		.collect(Collectors.averagingDouble(Employee::getSalay));
		System.out.println(double1);
		
		//总和
		employees.stream()
		.collect(Collectors.summarizingDouble(Employee::getSalay));
		
		//最大值
		Optional<Double> max = employees.stream()
		.map(Employee::getSalay)
		.collect(Collectors.maxBy(Double::compare));
		
		//最小值
	}

	public static void test6() {

		//分组
		Map<Status, List<Employee>> map = employees.stream()
		.collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
	}
	
	//多级分组
	public static void test7() {
		 Map<Status, Map<String, List<Employee>>> map = employees.stream()
		.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e)->{
			if(((Employee)e).getAge()<=35) {
				return "青年";
			}else if(((Employee)e).getAge()<=50) {
				return "中年";
			}else {
				return "老年";
			}
		})));
		System.out.println(map);
	}
	
	//分片区
	public static void test8() {
		Map<Boolean, List<Employee>> map = employees.stream()
		.collect(Collectors.partitioningBy((e)->e.getSalay()>5000));
		System.out.println(map);
	}
	
	public static void test9() {
		DoubleSummaryStatistics dss = employees.stream()
		.collect(Collectors.summarizingDouble(Employee::getSalay));
		System.out.println(dss.getAverage());
		System.out.println(dss.getMax());
		System.out.println(dss.getMin());
		
	}
	
	public static void test10() {
		String str = employees.stream()
		.map(Employee::getName)
		.collect(Collectors.joining(",","==","==="));
		System.out.println(str);
	}
}
