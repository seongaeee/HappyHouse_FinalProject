package com.happyhouse.service;

import java.util.ArrayList;

public interface AddressService {
	public ArrayList<String> selectSido(); //시 data
	public String sidoCode(String sido); //시 코드
	public ArrayList<String> selectGugun(String sido); //구 data
	public String gugunCode(String gugun); //구 코드
	public ArrayList<String> selectDong(String gugun); //동 data
}
