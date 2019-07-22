package com.bjsxt.pojo;

public class Log {
	private int id;
	private String accout;
	private String accin;
	private double money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getAccin() {
		return accin;
	}
	public void setAccin(String accin) {
		this.accin = accin;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", accout=" + accout + ", accin=" + accin + ", money=" + money + "]";
	}
	
	
	
	
}
