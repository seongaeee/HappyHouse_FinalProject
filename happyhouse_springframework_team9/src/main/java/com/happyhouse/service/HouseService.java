package com.happyhouse.service;

import java.util.ArrayList;
import java.util.Map;

import com.happyhouse.vo.HouseDeal;
import com.happyhouse.vo.HouseInfo;

//Controller를 위한 인터페이스
public interface HouseService {
	public ArrayList<HouseInfo> selectAll();
	public ArrayList<HouseDeal> selectDong(String dong);
	public ArrayList<HouseInfo> deepSearch(Map<String, String> map);
	public HouseInfo selectNo(String no);

}
