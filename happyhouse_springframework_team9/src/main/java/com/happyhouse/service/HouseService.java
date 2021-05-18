package com.happyhouse.service;

import java.util.ArrayList;

import com.happyhouse.vo.HouseInfo;

//Controller를 위한 인터페이스
public interface HouseService {
	public ArrayList<HouseInfo> selectAll();
	public ArrayList<HouseInfo> selectDong(String dong);
	public ArrayList<HouseInfo> selectApt(String apt);

}
