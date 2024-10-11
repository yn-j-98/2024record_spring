package com.koreait.app.biz.board;

public class BoardDTO {
	private int bid;
	private String content;
	private String writer;
	private String condition;
	private String keyword;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bid=" + bid + ", content=" + content + ", writer=" + writer + ", condition=" + condition
				+ ", keyword=" + keyword + "]";
	}
}
