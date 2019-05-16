package com.atguigu.java8;

public class Employee {

	private String name;
	private int age;
	private double salay;
	private Status status;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getSalay() {
		return salay;
	}


	public void setSalay(double salay) {
		this.salay = salay;
	}

	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salay=" + salay + ", status=" + status + "]";
	}

	public Employee(String name, int age, double salay, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.salay = salay;
		this.status = status;
	}

	
	public Employee(String name, int age, double salay) {
		super();
		this.name = name;
		this.age = age;
		this.salay = salay;
	}

	

	public Employee(int age) {
		super();
		this.age = age;
	}


	public Employee() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salay) != Double.doubleToLongBits(other.salay))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}



	public enum Status{
		FREE,
		BUSY,
		VOCATION;
	}
	
}
