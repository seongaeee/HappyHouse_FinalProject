package com.happyhouse.vo;

import com.happyhouse.dto.SessionUser;

//vo(value object):값을 저장하기 위한 용도.테이블 안의 레코드 한 건의 값을 저장하기 위한 목적
public class User {
	private String id;
	private String pass;
	private String name;
	private String email;
	private String tel;
	private String car;
	private String pet;
	private String scoreCheck;
	private String zip;
	private String address_base;
	private String address_detail;
	private String office_zip;
	private String office_address_base;
	private String office_address_detail;
	
	//constructor
	public User() {}
	
	public User(String name, String id, String tel) {
		super();
		this.name = name;
		this.id = id;
		this.tel = tel;
	}
	
	public User(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public User(String id, String pass, String name, String email, String tel, String car, String pet,
			String scoreCheck, String zip, String address_base, String address_detail, String office_zip,
			String office_address_base, String office_address_detail) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.car = car;
		this.pet = pet;
		this.scoreCheck = scoreCheck;
		this.zip = zip;
		this.address_base = address_base;
		this.address_detail = address_detail;
		this.office_zip = office_zip;
		this.office_address_base = office_address_base;
		this.office_address_detail = office_address_detail;
	}

	//점수계산을 위한 생성자
	public User(String id, String car, String pet, String scoreCheck, String office_address_base) {
		super();
		this.id = id;
		this.car = car;
		this.pet = pet;
		this.scoreCheck = scoreCheck;
		this.office_address_base = office_address_base;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getScoreCheck() {
		return scoreCheck;
	}

	public void setScoreCheck(String scoreCheck) {
		this.scoreCheck = scoreCheck;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress_base() {
		return address_base;
	}

	public void setAddress_base(String address_base) {
		this.address_base = address_base;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getOffice_zip() {
		return office_zip;
	}

	public void setOffice_zip(String office_zip) {
		this.office_zip = office_zip;
	}

	public String getOffice_address_base() {
		return office_address_base;
	}

	public void setOffice_address_base(String office_address_base) {
		this.office_address_base = office_address_base;
	}

	public String getOffice_address_detail() {
		return office_address_detail;
	}

	public void setOffice_address_detail(String office_address_detail) {
		this.office_address_detail = office_address_detail;
	}
	
}
