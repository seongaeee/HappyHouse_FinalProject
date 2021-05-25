package com.happyhouse.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.service.DistService;
import com.happyhouse.service.HouseService;
import com.happyhouse.service.UserService;
import com.happyhouse.vo.HouseInfo;
import com.happyhouse.vo.Position;
import com.happyhouse.vo.User;

@RestController
public class ScoreContoller {

	@Autowired
	HouseService hService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	DistService dService;
	
	//매물과 공원, 지하철, 직장과의 거리 구하기
	@PutMapping(value = "/dist")
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
			Map<String, String> map = new HashMap<String, String>();
		    map.put("no", house.getNo());
			map.put("stationDist", Double.toString(stationMindist));
		    map.put("parkDist", Double.toString(parkMindist));
		    hService.distUpdate(map);
		}
		System.out.println("성공");
	}
	
	//위도경도를 이용하여 거리 계산
	private double distance(HouseInfo house, Position position) {
		
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

    @PutMapping(value = "/getPosition")
    public String getPosition(User user) {
    	return getKakaoApiFromAddress(user.getAddress_base()); //수정 필요
    }

	//카카오 api를 이용하여 위치의 위도/경도 얻기
    public String getKakaoApiFromAddress(String roadFullAddr) {
        String apiKey = "a8cdd5e026f1e687e57278bc3d34aeeb";
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        String jsonString = null;

        try {
            roadFullAddr = URLEncoder.encode(roadFullAddr, "UTF-8");

            String addr = apiUrl + "?query=" + roadFullAddr;

            URL url = new URL(addr);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

            BufferedReader rd = null;
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer docJson = new StringBuffer();

            String line;

            while ((line=rd.readLine()) != null) {
                docJson.append(line);
            }

            jsonString = docJson.toString();
            rd.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
