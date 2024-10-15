package com.yn.app.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yn.app.biz.common.JDBCUtil;

@Repository
public class BoardDAO {
	private final String SELECTALL = "SELECT BID,CONTENT,WRITER FROM BOARD";
	private final String SELECTALL_CONTENT = "SELECT BID,CONTENT,WRITER FROM BOARD WHERE CONTENT LIKE CONCAT('%',?,'%')";
	private final String SELECTALL_WRITER = "SELECT BID,CONTENT,WRITER FROM BOARD WHERE WRITER=?";
	private final String INSERT = "INSERT INTO BOARD (CONTENT,WRITER) VALUES(?,?)";
	
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		List<BoardDTO> datas=new ArrayList<BoardDTO>();
		
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt=null;
		int rsCnt = 1; // 로그용
		try {
			if(boardDTO.getCondition() == null) {
				pstmt = conn.prepareStatement(SELECTALL);
			}
			else if(boardDTO.getKeyword().equals("")) { // 공백일 경우
				return datas;
			}
			else if(boardDTO.getCondition().equals("CONTENT")) {
				pstmt = conn.prepareStatement(SELECTALL_CONTENT);
				pstmt.setString(1, boardDTO.getKeyword());
			    System.out.println("SELECTALL_CONTENT pstmt 준비 완료");
			}
			else if(boardDTO.getCondition().equals("WRITER")) {
				pstmt = conn.prepareStatement(SELECTALL_WRITER);
				pstmt.setString(1, boardDTO.getKeyword());
			    System.out.println("SELECTALL_WRITER pstmt 준비 완료");

			}			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("SELECTALL RS "+rsCnt);
				BoardDTO data=new BoardDTO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
				rsCnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return datas;
	}
	public BoardDTO selectOne(BoardDTO boardDTO) {
		return null;
	}
	public boolean insert(BoardDTO boardDTO) {
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, boardDTO.getContent());
			pstmt.setString(2, boardDTO.getWriter());
			int result=pstmt.executeUpdate();
			if(result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		return false;
	}
	public boolean delete(BoardDTO boardDTO) {
		return false;
	}
}
