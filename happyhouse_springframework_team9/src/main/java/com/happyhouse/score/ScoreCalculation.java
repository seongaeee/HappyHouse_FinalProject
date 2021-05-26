package com.happyhouse.score;

import java.util.Map;

public class ScoreCalculation {
	
	//점수 계산
    public String getScore(Map<String, Double> map) {
		
    	double score = 0; //점수
    	double ratio = 0; //비율
    	int mapsize = map.size();
    	if(mapsize==0) return "10";
    	if(mapsize==1) ratio=1;
    	if(mapsize==2) ratio=0.5;
    	if(mapsize==3) ratio=0.33;
    	
		if(map.get("car")!=null) {
			if(map.get("car")<=1) { //1km 이하
				score += (10 - (map.get("car")*10)/1) * ratio; 
			}
		}
		if(map.get("pet")!=null) {
			if(map.get("pet")<=2) { //2km 이하
				score += (10 - (map.get("pet")*10)/2) * ratio; 
			}			
		}
		if(map.get("office")!=null) {
			if(map.get("office")<=20) { //20km 이하
				score += (10 - (map.get("office")*10)/20) * ratio; 
			}			
		}
		
    	return Double.toString(score);
    }
}
