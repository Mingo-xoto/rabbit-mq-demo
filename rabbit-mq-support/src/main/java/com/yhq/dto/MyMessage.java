package com.yhq.dto;

import java.io.Serializable;

/**
 * @author HuaQi.Yang
 * @date 2017年5月24日
 */
public class MyMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3335214818101462476L;
	private String name;
	private String sex;
	private String message;
	private int age;
	private double treasure;

	public MyMessage() {

	}

	public MyMessage(String name, String sex, String message, int age, double treasure) {
		super();
		this.name = name;
		this.sex = sex;
		this.message = message;
		this.age = age;
		this.treasure = treasure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTreasure() {
		return treasure;
	}

	public void setTreasure(double treasure) {
		this.treasure = treasure;
	}

	@Override
	public String toString() {
		return "MyMessage [name=" + name + ", sex=" + sex + ", message=" + message + ", age=" + age + ", treasure="
				+ treasure + "]";
	}

}
