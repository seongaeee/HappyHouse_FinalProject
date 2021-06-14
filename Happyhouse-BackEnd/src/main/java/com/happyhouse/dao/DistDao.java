package com.happyhouse.dao;

import java.util.ArrayList;

import com.happyhouse.vo.Position;

public interface DistDao {
	public ArrayList<Position> stationSelectAll();
	public ArrayList<Position> parkSelectAll();
}
