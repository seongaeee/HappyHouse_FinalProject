package com.happyhouse.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.UserDao;
import com.happyhouse.dto.SessionUser;
import com.happyhouse.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao; //인터페이스 타입으로 레퍼런스 선언 (나중에 코드의 유연성, 변동사항에서 영향을 덜 받게 하기 위해서)
	
	@Override
	public void registerMember(User user) {
		dao.registerMember(user);

	}

	@Override
	public User login(Map<String, String> map) {
		return dao.login(map);
	}

	@Override
	public User getMember(String userId) {
		return dao.getMember(userId);
	}

	@Override
	public void modifyMember(User user) {
		dao.modifyMember(user);
	}

	@Override
	public void deleteMember(String userId) {
		dao.deleteMember(userId);
	}

	@Override
	public User findPass(Map<String, String> map) {
		return dao.findPass(map);
	}

	//jwt를 위한 로그인 처리
	@Override
	public SessionUser signin(String id, String pass) {
		if (id.equals("abc@def.net") && pass.equals("1234")) {
            return new SessionUser(id, pass);
        } else {
            throw new RuntimeException("그런 사람은 없어요~");
        }
	}

	@Override
	public String getServerInfo() {
		return "정보 전달 함수";
	}
}
