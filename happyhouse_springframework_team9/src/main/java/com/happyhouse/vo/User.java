package com.happyhouse.vo;

import com.happyhouse.dto.SessionUser;

//vo(value object):값을 저장하기 위한 용도.테이블 안의 레코드 한 건의 값을 저장하기 위한 목적
public class User {
	private String id;
	private String pass;
	private String name;
	private String email;
	private String address;
	private String tel;
	private String office;
	private String car;
	private String pet;
	
	//constructor
	public User() {}

	public User(String id, String pass, String name, String email, String address, String tel) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}

	public User(String id, String pass, String name, String email, String address, String tel, String office,
			String car, String pet) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.office = office;
		this.car = car;
		this.pet = pet;
	}

	//jwt를 위한 comstructor
	public SessionUser makeSessionUser() {
		return new SessionUser(this.id, this.pass);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

}
