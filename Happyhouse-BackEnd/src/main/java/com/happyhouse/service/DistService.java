package com.happyhouse.service;

import java.util.ArrayList;

import com.happyhouse.vo.Position;

public interface DistService {
	public ArrayList<Position> stationSelectAll();
	public ArrayList<Position> parkSelectAll();
}
