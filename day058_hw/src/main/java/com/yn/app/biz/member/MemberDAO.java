package com.yn.app.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yn.app.biz.common.JDBCUtil;

@Repository
public class MemberDAO {
	private final String SELECTONE_IDCHECK = "SELECT MID FROM MEMBER WHERE MID=? ";
	private final String SELECTONE_LOGIN = "SELECT MID, PASSWORD FROM MEMBER WHERE MID=? AND PASSWORD=?";
	private final String INSERT = "INSERT INTO MEMBER(NAME,MID, PASSWORD) VALUES (?,?,?)";
	
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		return null;
	}
	public MemberDTO selectOne(MemberDTO memberDTO) {
		System.out.println("MemberDTO selectOne 시작");
		MemberDTO data=null;

		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt;
		try {
			//아이디 중복검사
			if(memberDTO.getCondition().equals("SELECTONE_IDCHECK")) {
				pstmt = conn.prepareStatement(SELECTONE_IDCHECK);
				pstmt.setString(1, memberDTO.getMid());
			    System.out.println("SELECTONE_IDCHECK pstmt 준비 완료");
			    ResultSet rs=pstmt.executeQuery();
			    if(rs.next()) {
			    	data=new MemberDTO();
			    	data.setMid(rs.getString("MID"));
			    }

			}
			// 로그인
			else if(memberDTO.getCondition().equals("SELECTONE_LOGIN")) {
				pstmt = conn.prepareStatement(SELECTONE_LOGIN);
				pstmt.setString(1, memberDTO.getMid());
				pstmt.setString(2, memberDTO.getPassword());
			    System.out.println("SELECTONE_LOGIN pstmt 준비 완료");
			    ResultSet rs=pstmt.executeQuery();
			    if(rs.next()) {
			    	data=new MemberDTO();
			    	data.setMid(rs.getString("MID"));
			    	data.setPassword(rs.getString("PASSWORD"));
			    }

			}
			else if(memberDTO.getCondition() == null) {
				System.out.println("condition null");
				return null;
			}
			else {
				System.out.println("condition 틀림");
				return null;
			}
		} catch (SQLException e) {
			System.err.println("MemberDAO selectOne sql문 실패");
			e.printStackTrace();
			return null;
			}
		System.out.println("memberDAO.selectOne 맞는 데이터 존재함");

		return  data;
	}
	public boolean insert(MemberDTO memberDTO) {
		System.out.println("MemberDAO insert 시작");
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			// 회원가입
			if(memberDTO.getCondition().equals("INSERT")) {
				pstmt = conn.prepareStatement(INSERT);
				pstmt.setString(1, memberDTO.getName());
				pstmt.setString(2, memberDTO.getMid());
				pstmt.setString(3, memberDTO.getPassword());
			    System.out.println("INSERT pstmt 준비 완료");

			}
			else if(memberDTO.getCondition() == null) {
				System.out.println("condition null");
				return false;
			}
			else {
				System.out.println("condition 틀림");
				return false;
			}
			int rs = pstmt.executeUpdate();
			if(rs<=0) {
				System.err.println("MemberDAO insert 실패");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO insert sql문 실패");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("MemberDAO insert문 성공");
		return true;
	}
	public boolean update(MemberDTO memberDTO) {
		return false;
	}
	public boolean delete(MemberDTO memberDTO) {
		return false;
	}
}
