package com.happyhouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.score.DistCalculation;
import com.happyhouse.service.DistService;
import com.happyhouse.service.HouseService;
import com.happyhouse.service.UserService;
import com.happyhouse.vo.HouseInfo;
import com.happyhouse.vo.Position;

@RestController
public class DistContoller {

	@Autowired
	HouseService hService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	DistService dService;
	
	DistCalculation dc = new DistCalculation();
	
	//매물과 공원, 지하철 거리 구하기
	@PutMapping(value = "/dist")
	public void Dist() {
		ArrayList<Position> stations = dService.stationSelectAll();
		ArrayList<Position> parks = dService.parkSelectAll();
		ArrayList<HouseInfo> houses = hService.selectAll();	
		
		//매물마다 거리 계산
		for (HouseInfo house : houses) {
			double parkMindist = Double.MAX_VALUE;
			double stationMindist = Double.MAX_VALUE;
			
			//공원과의 거리 계산하고 가장 가까운 거리 얻기
			for(Position park : parks) {
				if(park.getLat().equals("") || park.getLng().equals("") || house.getLat().equals("") || house.getLng().equals("")) continue;
				parkMindist = Math.min(parkMindist, dc.getDistance(house, park));
			}
			
			//지하철과의 거리 계산하고 가장 가까운 거리 얻기
			for(Position station : stations) {
				if(station.getLat().equals("") || station.getLng().equals("") || house.getLat().equals("") || house.getLng().equals("")) continue;
				stationMindist = Math.min(stationMindist, dc.getDistance(house, station));
			}
			
			//매물 DB update
			Map<String, String> map = new HashMap<String, String>();
		    map.put("no", house.getNo());
			map.put("stationDist", Double.toString(stationMindist));
		    map.put("parkDist", Double.toString(parkMindist));
		    hService.distUpdate(map);
		}
		System.out.println("성공");
	}
	
}
