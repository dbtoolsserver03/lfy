package com.atguigu.boot.bean;


public class Pet {

    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}

}
