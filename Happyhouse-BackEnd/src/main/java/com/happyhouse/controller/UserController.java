package com.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.dto.SessionUser;
import com.happyhouse.service.JwtService;
import com.happyhouse.service.UserService;
import com.happyhouse.vo.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

	@Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/signin")
    public ResponseEntity<Map<String, Object>> signin(@RequestBody SessionUser user,
            HttpServletResponse res) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
    
        try {
            SessionUser loginUser = userService.signin(user.getId(), user.getPass());
            // 로그인 성공했다면 토큰을 생성한다.
            String token = jwtService.create(loginUser);
            // 토큰 정보는 request의 헤더로 보내고 나머지는 Map에 담아주자.
            res.setHeader("jwt-auth-token", token);
            // resultMap.put("auth_token", token);

            resultMap.put("status", true);
            resultMap.put("data", loginUser);
            status = HttpStatus.ACCEPTED;
        } catch (RuntimeException e) {
            log.error("로그인 실패", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/info")
    public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req,
            @RequestBody User user) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            // 사용자에게 전달할 정보이다.
            String info = userService.getServerInfo();
            // 보너스로 토큰에 담긴 정보도 전달해보자. 서버에서 토큰을 사용하는 방법임을 알 수 있다.
            resultMap.putAll(jwtService.get(req.getHeader("jwt-auth-token")));

            resultMap.put("status", true);
            resultMap.put("info", info);
            resultMap.put("request_body", user);
            status = HttpStatus.ACCEPTED;
        } catch (RuntimeException e) {
            log.error("정보조회 실패", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
