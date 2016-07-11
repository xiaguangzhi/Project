package com.iotek.entry;

public class User {
	private int uid;//用户id
	private String name;//
	private String password;//
	private int type;//0表示普通用户   1：表示管理员
	private String address;//用户地址
	private String email;//用户邮箱
	
	public User() {
		super();
	}

	public User(String name, String password) {
	
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, int type) {
	
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public User(int uid, String name, String password, int type,
			String address, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.type = type;
		this.address = address;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password
				+ ", type=" + type + ", address=" + address + ", email="
				+ email + "]";
	}
	

}
