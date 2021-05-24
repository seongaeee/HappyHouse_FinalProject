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
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.dao.HouseDao;
import com.happyhouse.service.HouseService;
import com.happyhouse.service.UserService;
import com.happyhouse.vo.HouseInfo;
import com.happyhouse.vo.User;

@RestController
public class HomeRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HouseService hService;
	
	@Autowired
	UserService uService;
	
	@PostMapping(value ="/search/{dong}")
	public ArrayList<HouseInfo> selectDong(@PathVariable String dong) {
		return hService.selectDong(dong);
	}
	
	@GetMapping(value ="/detail/name/{aptName}")
	public ArrayList<HouseInfo> deepSearch(@PathVariable String aptName) {
		return hService.selectApt(aptName);
	}
	
	@GetMapping(value ="/detail/no/{no}")
	public HouseInfo deepSearchNo(@PathVariable String no) {
		return hService.selectNo(no);
	}
	
	@PostMapping(value = "/signUpProcess")
	public User signUpProcess(User user, HttpSession session) {
		return uService.getMember(user.getId()); //alreadyExist 체크
	}
	
	@PostMapping(value = "/modifyinfo")
	public void modifyInfo(User user, HttpSession session) {
		uService.modifyMember(user);
	}
	
	@PostMapping(value = "/findPass")
	public User findPass(String name, String id, String tel, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
	    map.put("name", name);
		map.put("id", id);
	    map.put("tel", tel);
	
		return uService.findPass(map);
	}
	
	@PostMapping(value = "/dropOut")
	public void dropOut(User user, HttpSession session) {
		uService.deleteMember(user.getId());
	}
}
