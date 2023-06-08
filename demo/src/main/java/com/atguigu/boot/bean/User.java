package com.atguigu.boot.bean;


/**
 * 用户
 */

public class User {

    private String name;
    private Integer age;
    private Pet pet;
    

    public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}
    


}
