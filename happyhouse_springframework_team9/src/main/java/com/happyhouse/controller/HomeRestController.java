package com.happyhouse.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.dao.HouseDao;
import com.happyhouse.service.DistService;
import com.happyhouse.service.HouseService;
import com.happyhouse.service.UserService;
import com.happyhouse.vo.HouseDeal;
import com.happyhouse.vo.HouseInfo;
import com.happyhouse.vo.Position;
import com.happyhouse.vo.User;

@RestController
public class HomeRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HouseService hService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	DistService dService;
	
	//동으로 검색
	@PostMapping(value ="/search/{dong}")
	public ArrayList<HouseDeal> selectDong(@PathVariable String dong) {
		return hService.selectDong(dong);
	}
	
	//동과 아파트 이름으로 상세 검색
	@GetMapping(value ="/detail/{dong}/{aptName}")
	public HouseInfo deepSearch(@PathVariable String dong, @PathVariable String aptName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong", dong);
		map.put("aptName", aptName);
		
		return hService.deepSearch(map);
	}
	
	//로그인
	@PostMapping(value = "/loginProcess")
	public User loginProcess(@RequestBody User user) {
		System.out.println(user.getId());
		System.out.println(user.getPass());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", user.getId());
		map.put("pass", user.getPass());
		return uService.login(map);
	}
	
	//회원 정보 얻기
	@GetMapping(value = "/getMember/{id}")
	public boolean getMember(@PathVariable String id) {
		User user = uService.getMember(id);
		
		if(user != null) return true;
		else return false;
	}
	
	//회원가입
	@PostMapping(value = "/signUpProcess")
	public void signUpProcess(@RequestBody User user) {
		uService.registerMember(user);
	}
	
	//회원정보 수정
	@PostMapping(value = "/modifyinfo")
	public void modifyInfo(@RequestBody User user) {
		uService.modifyMember(user);
	}
	
	//비밀번호 찾기
	@PostMapping(value = "/findPass")
	public User findPass(@RequestBody String name, @RequestBody String id, @RequestBody String tel) {
		Map<String, String> map = new HashMap<String, String>();
	    map.put("name", name);
		map.put("id", id);
	    map.put("tel", tel);
	
		return uService.findPass(map);
	}
	
	//회원 탈퇴
	@PostMapping(value = "/dropOut")
	public void dropOut(@RequestBody User user) {
		uService.deleteMember(user.getId());
	}
	
}
