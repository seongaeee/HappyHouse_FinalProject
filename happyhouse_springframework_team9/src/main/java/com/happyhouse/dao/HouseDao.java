package com.happyhouse.dao;

import java.util.ArrayList;

import com.happyhouse.vo.HouseInfo;

//Service를 위한 인터페이스
public interface HouseDao {
	public ArrayList<HouseInfo> selectAll();
	public ArrayList<HouseInfo> selectDong(String dong);
	public ArrayList<HouseInfo> selectApt(String apt);

}
