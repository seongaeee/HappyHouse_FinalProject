package com.happyhouse.service;

import java.util.Map;

import com.happyhouse.dto.SessionUser;
import com.happyhouse.vo.User;

public interface JwtService {

	public String create(final SessionUser loginUser);
    public void checkValid(final String jwt);
    public Map<String, Object> get(final String jwt);
}
