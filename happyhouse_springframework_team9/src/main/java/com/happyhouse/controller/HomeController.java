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
import org.springframework.web.bind.annotation.PostMapping;

import com.happyhouse.dao.HouseDao;
import com.happyhouse.service.HouseService;
import com.happyhouse.service.UserService;
import com.happyhouse.vo.HouseInfo;
import com.happyhouse.vo.User;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HouseService hService;
	
	@Autowired
	UserService uService;
	
	@GetMapping(value = "/")
	public String home() {
		return "main";
	}
	
	@PostMapping(value ="/selectDong")
	public String selectDong(String dong, Model model) {
		ArrayList<HouseInfo> list = hService.selectDong(dong);
		model.addAttribute("list", list);
		return "searchPage";
	}
	
	@GetMapping(value ="/deepSearch")
	public String deepSearch(String aptName, Model model) {
		ArrayList<HouseInfo> list = hService.selectApt(aptName);
		model.addAttribute("list", list);
		return "deepSearchPage";
	}
	
	@PostMapping(value = "/loginProcess") 
	public String loginProcess(String SignInID, String SignInPW, Model model, HttpSession session) {
		
		Map<String, String> map = new HashMap<String, String>();
	    map.put("id", SignInID);
	    map.put("pass", SignInPW);
	    
	    User user = uService.login(map);
	    if(user != null) {
	        session.setAttribute("id", user.getId());
	        session.setAttribute("pass", user.getPass());
	        session.setAttribute("name", user.getName());
	        session.setAttribute("email", user.getEmail());
	        session.setAttribute("address", user.getAddress());
	        session.setAttribute("tel", user.getTel());
		    
		    return "main";
	    }else{
	    	return "loginError";
	    }
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
        
		return "main";
	}
	
	@GetMapping(value = "/loginError")
	public String loginError() {
		return "loginError";
	}
	
	@PostMapping(value = "/signUpProcess")
	public String signUpProcess(User user, HttpSession session) {
		
		User alreadyExist = uService.getMember(user.getId());
		if(alreadyExist != null) {
			return "signUpError";
		}else {
			uService.registerMember(user);
			
			session.setAttribute("id", user.getId());
	        session.setAttribute("pass", user.getPass());
	        session.setAttribute("name", user.getName());
	        session.setAttribute("email", user.getEmail());
	        session.setAttribute("address", user.getAddress());
	        session.setAttribute("tel", user.getTel());
			
	        return "main";
		}
	}
	
	@PostMapping(value = "/modifyinfo")
	public String modifyInfo(User user, HttpSession session) {
		
		uService.modifyMember(user);
		
		session.setAttribute("id", user.getId());
        session.setAttribute("pass", user.getPass());
        session.setAttribute("name", user.getName());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("address", user.getAddress());
        session.setAttribute("tel", user.getTel());
		
        return "main";
	}
	
	@PostMapping(value = "/findPass")
	public String findPass(String name, String id, String tel, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
	    map.put("name", name);
		map.put("id", id);
	    map.put("tel", tel);
	
		User user = uService.findPass(map);
		
		if(user == null) {
			return "findPassError";
		}else {
			session.setAttribute("id", user.getId());
	        session.setAttribute("pass", user.getPass());
	        session.setAttribute("name", user.getName());
	        session.setAttribute("email", user.getEmail());
	        session.setAttribute("address", user.getAddress());
	        session.setAttribute("tel", user.getTel());
			
	        return "newPass";
		}
	}
	
	@PostMapping(value = "/dropOut")
	public String dropOut(User user, HttpSession session) {
		uService.deleteMember(user.getId());
		session.setAttribute("id", null);
		return "main";
	}
}
