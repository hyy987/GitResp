package com.atguigu.java8;

public class FilterByEmployeeAge implements MyPredicate<Employee>
{

	@Override
	public boolean test(Employee t) {
		
		return t.getAge()>=30;
	}

}
