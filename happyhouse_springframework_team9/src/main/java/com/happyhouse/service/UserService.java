package com.happyhouse.service;
import java.util.Map;

import com.happyhouse.vo.User;

public interface UserService {

//	회원가입
	void registerMember(User user);
	
//	로그인
	User login(Map<String, String> map);
	
//	회원정보 수정을 위한 회원의 모든 정보 얻기
	User getMember(String userId);
	
//	회원정보 수정
	void modifyMember(User user);
	
//	회원탈퇴
	void deleteMember(String userId);

//  비밀번호 찾기를 위한 정보 얻기
	User findPass(Map<String, String> map);
	
	
}
