package com.happyhouse.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.HouseDao;
import com.happyhouse.vo.HouseDeal;
import com.happyhouse.vo.HouseInfo;

//3-BoardService의 메소드를 구현한 객체.
//Controller에서 들어온 요청을 실제로 처리하는 객체
//DAO에게 요청사항을 전달함
@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	HouseDao dao; //인터페이스 타입으로 레퍼런스 선언

	@Override
	public ArrayList<HouseInfo> selectAll() {
		return dao.selectAll();
	}
	@Override
	public ArrayList<HouseDeal> selectDong(String dong) {
		return dao.selectDong(dong);
	}
	
	@Override
	public HouseInfo deepSearch(Map<String, String> map) {
		return dao.deepSearch(map);
	}

	@Override
	public HouseInfo selectNo(String no) {
		return dao.selectNo(no);
	}
	@Override
	public void distUpdate(Map<String, String> map) {
		dao.distUpdate(map);
	}

}
