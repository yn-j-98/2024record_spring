package com.yn.app.biz.board;

import org.springframework.stereotype.Component;

@Component("boardDTO")
public class BoardDTO {
	private int board_num;
	private String board_title;
	private String board_content;
	private String board_writer;
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	@Override
	public String toString() {
		return "BoardDTO [board_num=" + board_num + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + "]";
	}
	
	

}
