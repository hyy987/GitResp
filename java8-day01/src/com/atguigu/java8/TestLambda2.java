package com.atguigu.java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 1.lambda表达式的基础语法：Java8中引入了一个新的操作符"->"该操作符为箭头操作符或Lambda操作符
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体
 * @author admin
 * 
 * 语法格式一：无参，无返回值
 * 		()->sysotem.out.println("Hello Lambda!");
 * 语法格式二：有一个参数并且无返回值
 * 		(x)->sysotem.out.println(x);
 * 语法格式三：有一个参数小括号可以省略不写
 * 		x->System.out.println(x);
 * 语法格式四：有两个以上的参数，并且LAmdba中有多条返回语句
 * 	Comparator<Integer> com = (x,y)->{
			System.out.println("函数式接口");
			return  Integer.compare(x,y);
		};
	
	
 *
 *语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 *
 *语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即”类型推断“
 *
 *上联：左右遇一括号省
 *下联：左侧推断类型省
 *横批：能省则省
 *
 *Lambda表达式需要函数式接口的支持
 *函数式接口：接口中只有一个抽象方法的接口，成为函数式接口。可以使用注解@FunctionalInterface修饰可以检查接口是否为函数式接口
 */
public class TestLambda2 {

	public static void main(String[] args) {
		test1();
		test2();
		test4();
		test6();
	}
	
	public static void test1() {
		int num =0;//jdk1.7前，必须是final
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello Lambda!"+num);
				
			}
		};
		r.run();
		System.out.println("---------------------");
		Runnable r1 = ()->System.out.println("Hello World!"+num);
		r1.run();
	}
	
	public static void test2() {
		Consumer<String> com = (x)->System.out.println(x);
		com.accept("我大尚硅谷为辅");
	}
	
	
	public static void test3() {
		Comparator<Integer> com = (x,y)->{
			System.out.println("函数式接口");
			return  Integer.compare(x,y);
		};
		
	}
	
	public static void test4() {
		Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
		};
		
		//需求：对一个数进行运算
		public static void test6() {
			Integer operation = operation(100, (x)->x*x);
			System.out.println(operation);
		}
		
		public static Integer operation(Integer num,MyFun mf) {
			return mf.getValue(num);
		}
}
