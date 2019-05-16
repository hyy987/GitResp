package com.atguigu.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法使用：若Lambda体中内容有方法实现了，我们可以使用"方法引用" （可以理解为方法应用是Lambda表达式的另外一种表现形式 ）
 * 
 * @author admin 主要有三种语法格式：
 *  对象：：实例方法名 
 *  类：：静态方法名 
 *  类：：实例方法名
 *
 *     注意： 1.lambda体中的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *         	2若Lambda参数列表中的第一参数是实例方法的调用者，而第二个参数是实例方法的参数时候i，可以使用CalssName::method.
 *二、构造器引用：
 *格式：
 *Classname::new
 *
 *注意：需要调用的构造器的参数列表要与函数式接口参数列表保持一致
 *
 *三：数组引用：
 *Type::new
 */
public class TestMethodRef {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test5();
//		test6();
		test7();
	}

	// 对象：：实例方法名
	public static void test1() {
		Consumer<String> con = (x) -> System.out.println(x);

		// 方法引用
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;

		Consumer<String> con2 = System.out::println;
		con2.accept("abcdfr");
	}

	public static void test2() {
		Employee e = new Employee();
		Supplier<String> sup = () -> e.getName();
		String string = sup.get();
		System.out.println(string);

		Supplier<Integer> sup2 = e::getAge;
		Integer integer = sup2.get();
		System.out.println(integer);
	}

	// 类：：静态方法名
	public static void test3() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

		Comparator<Integer> com1 = Integer::compare;
	}

	// 类：实列化方法名
	public static void test4() {
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		
		BiPredicate<String, String> bp2 =String::equals;
	}

	//构造器引用
	public static void test5() {

		Supplier<Employee> sup =()->new Employee();
//		Employee employee = sup.get();
		
		//构造器引用方式
		Supplier<Employee> sup2=Employee::new;
		System.out.println(sup2.get());
	}
	
	public static void test6() {
		Function<Integer, Employee> fun=(x)->new Employee(x);
		
		Function<Integer, Employee> fun2= Employee::new;
		System.out.println(fun2.apply(74));
	}
	//数组引用
	public static void test7() {
		Function<Integer, String[]> fun =(x)->new String[x];
		String[] strs =fun.apply(10);
		System.out.println(strs.length);
		
		Function<Integer, String[]> fun2 =String[]::new;
		System.out.println(fun2.apply(2).length);
	}
	public static void test8() {}
	public static void test9() {}
	public static void test10() {}
}
