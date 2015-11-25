package com.demo.domain;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String name;
	private String age;
	private String password;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public User(int cid, String name, String password) {
		this.cid = cid;
		this.name = name;
		this.password = password;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}