package com.happyhouse.score;

import java.util.Map;

import com.happyhouse.vo.HouseInfo;

public class ScoreCalculation {
	
	//점수 계산
    public HouseInfo getScore(Map<String, Double> map, HouseInfo houseinfo) {
		
    	double score = 0; //점수
    	double ratio = 0; //비율
    	int mapsize = map.size();
    	if(mapsize==0) {
    		houseinfo.setScore("10");
    		houseinfo.setStationScore("3.3");
    		houseinfo.setParkScore("3.3");
    		houseinfo.setOfficeScore("3.3");
    		return houseinfo;
    	}
    	if(mapsize==1) ratio=1;
    	if(mapsize==2) ratio=0.5;
    	if(mapsize==3) ratio=0.33;
    	
		if(map.get("car")!=null) {
			if(map.get("car")<=1) { //1km 이하
				double scoreStation = (10 - (map.get("car")*10)/1) * ratio; 
				score += scoreStation;
				houseinfo.setStationScore(Double.toString(scoreStation));
			}
		}
		if(map.get("pet")!=null) {
			if(map.get("pet")<=2) { //2km 이하
				double scorePark = (10 - (map.get("pet")*10)/2) * ratio; 
				score += scorePark;
				houseinfo.setParkScore(Double.toString(scorePark));
			}			
		}
		if(map.get("office")!=null) {
			if(map.get("office")<=20) { //20km 이하
				double scoreOffice = (10 - (map.get("office")*10)/20) * ratio;
				score += scoreOffice;
				houseinfo.setOfficeScore(Double.toString(scoreOffice));
			}			
		}
		
		houseinfo.setScore(Double.toString(score));
		
    	return houseinfo;
    }
}
