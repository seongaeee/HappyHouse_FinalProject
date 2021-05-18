package com.happyhouse.service;

import java.util.ArrayList;

import com.happyhouse.vo.Board;

public interface BoardService {

	public ArrayList<Board> selectAll();
	public Board selectOne(int no);
	public void delete(int no);
	public void update(Board board);
	public void insert(Board board); 
	
}
