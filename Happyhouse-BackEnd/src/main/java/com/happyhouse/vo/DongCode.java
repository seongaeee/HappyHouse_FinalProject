package com.happyhouse.vo;

//vo(value object):값을 저장하기 위한 용도.테이블 안의 레코드 한 건의 값을 저장하기 위한 목적
public class DongCode {
	private String dongCode;
	private String city;
	private String guGun;
	private String dong;

	//constructor
	public DongCode() {}

	public DongCode(String dongCode, String city, String guGun, String dong) {
		super();
		this.dongCode = dongCode;
		this.city = city;
		this.guGun = guGun;
		this.dong = dong;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGuGun() {
		return guGun;
	}

	public void setGuGun(String guGun) {
		this.guGun = guGun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}
	
}
