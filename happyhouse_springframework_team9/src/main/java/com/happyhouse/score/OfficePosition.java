package com.happyhouse.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.happyhouse.vo.Position;
import com.happyhouse.vo.User;

public class OfficePosition {
	
	//사용자 직장 위도 경도를 구하기
    public Position getOfficePosition(User user) {
    	
    	JSONObject json;
    	String officelng="";
    	String officelat="";
    	
    	try {
			json = ( JSONObject ) new JSONParser().parse( getKakaoApiFromAddress(user.getOffice_address_base()));
	    	JSONArray jsonDocuments = (JSONArray) json.get( "documents" );
		    
	    	
	    	if( jsonDocuments.size() != 0 ) {
			  	JSONObject j = (JSONObject) jsonDocuments.get(0);
			  	officelat = ( String ) j.get( "y" );
			   	officelng = ( String ) j.get( "x" );
	    	}
		}catch (ParseException e) {
			e.printStackTrace();
		}
    	
		Position office = new Position(officelat, officelng);
		
    	return office;
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
