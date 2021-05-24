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
	
	@PostMapping(value ="/search/{dong}")
	public ArrayList<HouseDeal> selectDong(@PathVariable String dong) {
		return hService.selectDong(dong);
	}
	
	@GetMapping(value ="/detail/{dong}/{aptName}")
	public ArrayList<HouseInfo> deepSearch(@PathVariable String dong, @PathVariable String aptName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong", dong);
		map.put("aptName", aptName);
		
		return hService.deepSearch(map);
	}
	
//	@GetMapping(value ="/detail/no/{no}")
//	public HouseInfo deepSearchNo(@PathVariable String no) {
//		return hService.selectNo(no);
//	}
	
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
	
	//매물과 공원, 지하철, 직장과의 거리 구하기
	@GetMapping(value = "/dist")
	public void Dist() {
		ArrayList<Position> stations = dService.stationSelectAll();
		ArrayList<Position> parks = dService.parkSelectAll();
		ArrayList<HouseInfo> houses = hService.selectAll();	
		
		double parkMindist = Double.MAX_VALUE;
		double stationMindist = Double.MAX_VALUE;
		
		int idx=0;
		//매물마다 거리 계산
		for (HouseInfo house : houses) {
			
			//공원과의 거리 계산하고 가장 가까운 거리 얻기
			for(Position park : parks) {
				if(park.getLat().equals("") || park.getLng().equals("") || house.getLat().equals("") || house.getLng().equals("")) continue;
				parkMindist = Math.min(parkMindist, distance(house, park));
			}
			
			//지하철과의 거리 계산하고 가장 가까운 거리 얻기
			for(Position station : stations) {
				if(station.getLat().equals("") || station.getLng().equals("") || house.getLat().equals("") || house.getLng().equals("")) continue;
				stationMindist = Math.min(stationMindist, distance(house, station));
			}
			
			//매물 DB update
			
		}
		System.out.println("성공");
	}

	private double distance(HouseInfo house, Position position) {
		
		double lat1 = Double.parseDouble(house.getLat());
		double lat2 = Double.parseDouble(position.getLat());
		double lon1 = Double.parseDouble(house.getLng());
		double lon2 = Double.parseDouble(position.getLng());
		
		double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
 
        return (dist);
	}
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
