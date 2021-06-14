package com.happyhouse.vo;

//vo(value object):값을 저장하기 위한 용도.테이블 안의 레코드 한 건의 값을 저장하기 위한 목적
public class LikeArea {
	private String userid;
	private String dong;
	
	//constructor
	public LikeArea() {}

	public LikeArea(String userid, String dong) {
		super();
		this.userid = userid;
		this.dong = dong;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}


	
	//getter/setter
	
}
