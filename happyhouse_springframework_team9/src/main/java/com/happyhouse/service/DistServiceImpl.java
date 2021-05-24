package com.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.DistDao;
import com.happyhouse.vo.Position;

@Service
public class DistServiceImpl implements DistService {

	@Autowired
	DistDao dao; //인터페이스 타입으로 레퍼런스 선언

	@Override
	public ArrayList<Position> stationSelectAll() {
		return dao.stationSelectAll();
	}

	@Override
	public ArrayList<Position> parkSelectAll() {
		return dao.parkSelectAll();
	}

}
