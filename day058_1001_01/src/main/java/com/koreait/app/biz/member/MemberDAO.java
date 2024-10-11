package com.koreait.app.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.app.biz.common.JDBCUtil;

@Repository
public class MemberDAO {
	private final String SELECTONE = "SELECT NAME FROM MEMBER WHERE MID=? AND PASSWORD=?";
	
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {

		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("로그");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return null;
	}
	public MemberDTO selectOne(MemberDTO memberDTO) {
		MemberDTO data=null;
		
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(SELECTONE);
			pstmt.setString(1, memberDTO.getMid());
			pstmt.setString(2, memberDTO.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberDTO();
				data.setName(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return  data;
	}
	public boolean insert(MemberDTO memberDTO) {
		return false;
	}
	public boolean update(MemberDTO memberDTO) {
		return false;
	}
	public boolean delete(MemberDTO memberDTO) {
		return false;
	}
}
