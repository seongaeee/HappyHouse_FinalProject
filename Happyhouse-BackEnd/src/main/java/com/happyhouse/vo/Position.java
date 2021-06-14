package com.happyhouse.vo;

public class Position {
	private String lat; //위도
	private String lng; //경도
	
	public Position() {}

	public Position(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
}
