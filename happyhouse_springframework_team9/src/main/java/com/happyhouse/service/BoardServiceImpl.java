package com.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.BoardDao;
import com.happyhouse.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao; //인터페이스 타입으로 레퍼런스 선언

	@Override
	public ArrayList<Board> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String no) {
		dao.updateCount(no);
		return dao.selectOne(no);
	}

	@Override
	public void delete(String no) {
		dao.delete(no);
	}

	@Override
	public void update(Board board) {
		dao.update(board);
	}

	@Override
	public void insert(Board board) {
		dao.insert(board);
	}

}
