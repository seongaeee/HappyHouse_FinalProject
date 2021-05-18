package com.happyhouse.vo;

public class Board {
	String no;
	String id;
	String title;
	String content;
	String wdate;
	String count;
	
	public Board() {
		super();
	}

	public Board(String no, String id, String title, String content, String wdate, String count) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.count = count;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	

}
