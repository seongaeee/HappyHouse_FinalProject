package com.happyhouse.dao;

import java.util.ArrayList;

import com.happyhouse.vo.Board;

public interface BoardDao {
	
	public ArrayList<Board> selectAll();
	public Board selectOne(String no);
	public void delete(String no);
	public void update(Board board);
	public void insert(Board board); 
	public void updateCount(String no);
}
