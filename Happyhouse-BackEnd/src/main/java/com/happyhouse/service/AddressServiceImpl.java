package com.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.AddressDao;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao dao;
	
	@Override
	public ArrayList<String> selectSido() {
		return dao.selectSido();
	}
	
	@Override
	public String sidoCode(String sido) {
		return dao.sidoCode(sido);
	}

	@Override
	public ArrayList<String> selectGugun(String sido) {
		return dao.selectGugun(sido);
	}

	@Override
	public String gugunCode(String gugun) {
		return dao.gugunCode(gugun);
	}

	@Override
	public ArrayList<String> selectDong(String gugun) {
		return dao.selectDong(gugun);
	}


}
