package com.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.LikeAreaDao;
import com.happyhouse.vo.LikeArea;

@Service
public class LikeAreaServiceImpl implements LikeAreaService {
	
	@Autowired
	LikeAreaDao dao; //인터페이스 타입으로 레퍼런스 선언 (나중에 코드의 유연성, 변동사항에서 영향을 덜 받게 하기 위해서)

	@Override
	public void addLikeArea(LikeArea area) {
		dao.addLikeArea(area);
	}

	@Override
	public void deleteLikeArea(LikeArea area) {
		dao.deleteLikeArea(area);
	}
}
