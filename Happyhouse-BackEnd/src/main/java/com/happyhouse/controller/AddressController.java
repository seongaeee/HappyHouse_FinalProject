package com.happyhouse.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService service;
	
	//시 데이터 가져오기
	@GetMapping(value="/address")
	public ArrayList<String> selectSido(){
		return service.selectSido();
	}
	
	//구 데이터 요청
	@GetMapping(value="/address/gugun/{sido}")
	public ArrayList<String> selectGugun(@PathVariable String sido){
		
		//1.선택된 시의 코드
		String sidoCode = service.sidoCode(sido);
		
		System.out.println(sidoCode);
		
		//2. 구 데이터 가져오기
		return service.selectGugun(sidoCode.substring(0,2));
	}
	
	//동 데이터 요청
	@GetMapping(value="/address/dong/{gugun}")
	public ArrayList<String> selectDong(@PathVariable String gugun){
		
		//1.선택된 시의 코드
		String gugunCode = service.gugunCode(gugun);
		
		//2. 구 데이터 가져오기
		return service.selectDong(gugunCode.substring(0,4));
	}
}
