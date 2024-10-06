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
	List<MemberDTO> selectAll(MemberDTO memberDTO) {

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
	MemberDTO selectOne(MemberDTO memberDTO) {
		return  null;
	}
	boolean insert(MemberDTO memberDTO) {
		return false;
	}
	boolean update(MemberDTO memberDTO) {
		return false;
	}
	boolean delete(MemberDTO memberDTO) {
		return false;
	}
}
