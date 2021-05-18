package com.happyhouse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.service.BoardService;
import com.happyhouse.vo.Board;

@CrossOrigin(origins="*")
@RestController
public class BoardController {

	@Autowired
	BoardService service;
	
	@GetMapping(value="/board")
	public ArrayList<Board> selectAll(){
		return service.selectAll();
	}

	@GetMapping(value="/board/{no}")
	public Board selectOne(@PathVariable String no){
		return service.selectOne(no);
	}
	
	@DeleteMapping(value="/board/{no}")
	public void delete(@PathVariable String no) {
		service.delete(no);
	};
	
	@PutMapping(value="/board")
	public void update(@RequestBody Board board) {
		service.update(board);
	};
	
	@PostMapping(value="/board")
	public void insert(@RequestBody Board board) {
		service.insert(board);
	}; 
	
}
