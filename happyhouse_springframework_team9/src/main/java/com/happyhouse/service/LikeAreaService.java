package com.happyhouse.service;

import com.happyhouse.vo.LikeArea;

public interface LikeAreaService {

//	관심지역 추가
	void addLikeArea(LikeArea area);
//	관심지역 삭제
	void deleteLikeArea(LikeArea area);
}
