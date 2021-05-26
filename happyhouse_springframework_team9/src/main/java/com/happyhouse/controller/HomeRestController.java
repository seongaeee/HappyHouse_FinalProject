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
import com.happyhouse.score.DistCalculation;
import com.happyhouse.score.OfficePosition;
import com.happyhouse.score.ScoreCalculation;
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
	
	OfficePosition op = new OfficePosition();
	DistCalculation dc = new DistCalculation();
	ScoreCalculation sc = new ScoreCalculation();
	
	//동으로 검색
	@PostMapping(value ="/search/{dong}")
	public ArrayList<HouseDeal> selectDong(@PathVariable String dong) {
		return hService.selectDong(dong);
	}
	
	//동과 아파트 이름으로 상세 검색 - 로그인x
	@GetMapping(value ="/detail/{dong}/{aptName}")
	public HouseInfo deepSearch(@PathVariable String dong, @PathVariable String aptName) {
		
		//1. 기존 HouseInfo 얻기
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong", dong);
		map.put("aptName", aptName);
		return hService.deepSearch(map);
	}
	
	//동과 아파트 이름으로 상세 검색 - 로그인o
	@PostMapping(value ="/detail/{dong}/{aptName}")
	public HouseInfo deepSearch(@PathVariable String dong, @PathVariable String aptName, @RequestBody User user) {
		
		System.out.println(user.getId());
		//1. 기존 HouseInfo 얻기
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong", dong);
		map.put("aptName", aptName);
		HouseInfo houseinfo = hService.deepSearch(map);
		
		//2-1. 점수 기능 제공x
		if(user.getScoreCheck().equals("N")) return hService.deepSearch(map);
		
		//2-2. 점수 기능 제공o
		Map<String, Double> distlist = new HashMap<String, Double>();
		if(user.getCar().equals("N")) {
			distlist.put("car",Double.parseDouble(houseinfo.getStationDist()));
		}
		if(user.getPet().equals("Y")) {
			distlist.put("pet",Double.parseDouble(houseinfo.getParkDist()));
		}
		if(!user.getOffice_zip().trim().equals("")) {
			Position office = op.getOfficePosition(user);
			double officeDist = dc.getDistance(houseinfo, office);
			distlist.put("office",officeDist);
		}
		
		return sc.getScore(distlist, houseinfo);
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
	public User findPass(@RequestBody User user) {
		Map<String, String> map = new HashMap<String, String>();
	    map.put("name", user.getName());
		map.put("id", user.getId());
	    map.put("tel", user.getTel());
	
		return uService.findPass(map);
	}
	
	//회원 탈퇴
	@PostMapping(value = "/dropOut")
	public void dropOut(@RequestBody User user) {
		uService.deleteMember(user.getId());
	}
	
}
