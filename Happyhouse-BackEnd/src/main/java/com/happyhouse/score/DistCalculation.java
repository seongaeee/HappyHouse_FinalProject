package com.happyhouse.score;

import com.happyhouse.vo.HouseInfo;
import com.happyhouse.vo.Position;

public class DistCalculation {
	//위도경도를 이용하여 거리 계산
	public double getDistance(HouseInfo house, Position position) {
		
		double lat1 = Double.parseDouble(house.getLat());
		double lat2 = Double.parseDouble(position.getLat());
		double lon1 = Double.parseDouble(house.getLng());
		double lon2 = Double.parseDouble(position.getLng());
		
		double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
 
        return (dist);
	}
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
