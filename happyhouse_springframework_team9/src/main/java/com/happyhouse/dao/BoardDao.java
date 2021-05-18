package com.happyhouse.dao;

import java.util.ArrayList;

import com.happyhouse.vo.Board;

public interface BoardDao {
	
	public ArrayList<Board> selectAll();
	public Board selectOne();
	public void delete(int no);
	public void update(Board board);
	public void insert(Board board); 
	
}
