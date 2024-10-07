package com.yn.app.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yn.app.biz.common.JDBCUtil;

@Repository
public class MemberDAO implements MemberService {

	private final String SEARCH_ALL = "SELECT MEMBER_NUM, MEMBER_ID, MEMBER_PASSWORD FROM MEMBER"; // 전체 회원 조회
	private final String SEARCH_ONE = "SELECT MEMBER_NUM, MEMBER_ID, MEMBER_PASSWORD FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?"; // 특정 회원 조회
	private final String INSERT = "INSERT INTO MEMBER (MEMBER_NUM, MEMBER_ID, MEMBER_PASSWORD) VALUES (?, ?, ?)"; // 회원가입
	private final String UPDATE = "UPDATE MEMBER SET MEMBER_PASSWORD = ? WHERE MEMBER_ID = ?"; // 비밀번호 수정
	private final String DELETE = "DELETE FROM MEMBER WHERE MEMBER_ID = ?"; // 회원 삭제


	
	@Autowired
	private MemberDTO memberDTO;

	@Override
	public List<MemberDTO> SelectAll(MemberDTO memberDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		List<MemberDTO> datas = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(SEARCH_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				this.memberDTO = new MemberDTO();
				this.memberDTO.setMember_num(rs.getInt("MEMBER_NUM"));
				this.memberDTO.setMember_id(rs.getString("MEMBER_ID"));
				this.memberDTO.setMember_password(rs.getString("MEMBER_PASSWORD"));
				this.memberDTO.setMember_role(rs.getBoolean("MEMBER_ROLE"));
				datas.add(this.memberDTO);
			}
		} catch (SQLException e) {
			System.err.println("SQL문 실패");
		}

		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}

	@Override
	public MemberDTO SelectOne(MemberDTO memberDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(SEARCH_ONE);
			pstmt.setString(1, memberDTO.getMember_id());
			pstmt.setString(2, memberDTO.getMember_password());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				this.memberDTO.setMember_num(rs.getInt("MEMBER_NUM"));
				this.memberDTO.setMember_id(rs.getString("MEMBER_ID"));
				this.memberDTO.setMember_password(rs.getString("MEMBER_PASSWORD"));
				this.memberDTO.setMember_role(rs.getBoolean("MEMBER_ROLE"));
			}
		} catch(SQLException e) {
			System.err.println("SQL문 실패");
		}
		JDBCUtil.disconnect(pstmt, conn);
		return this.memberDTO;
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		System.out.println("member.MemberDAO.insert 시작");
	    Connection conn = JDBCUtil.connect();
	    PreparedStatement pstmt = null;
	    try {
	    	// 회원가입
	        pstmt = conn.prepareStatement(INSERT);
	        pstmt.setInt(1, memberDTO.getMember_num());
	        pstmt.setString(2, memberDTO.getMember_id());
	        pstmt.setString(3, memberDTO.getMember_password());
	        
	        int rs = pstmt.executeUpdate();
			if(rs<=0) {
				System.err.println("member.MemberDAO.insert 실패");
				return false;
			}

		} catch (SQLException e) {
			System.out.println("member.MemberDAO.insert SQL문 실패");
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt,conn);
		}
		System.out.println("member.MemberDAO.insert 성공");
		return true;
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
	    System.out.println("member.MemberDAO.update 시작");	
	    Connection conn = JDBCUtil.connect();
	    PreparedStatement pstmt = null;
	    try {
	        // 회원 정보 수정
	        pstmt = conn.prepareStatement(UPDATE);
	        pstmt.setString(1, memberDTO.getMember_password()); // 비밀번호 수정
	        pstmt.setString(2, memberDTO.getMember_id()); // 조건으로 MEMBER_ID를 사용

	        int rs = pstmt.executeUpdate();
	        if (rs <= 0) {
	            System.err.println("member.MemberDAO.update 실패");
	            return false;
	        }

	    } catch (SQLException e) {
	        System.err.println("member.MemberDAO.update SQL문 실패");
	        return false;
	    } finally {
	        JDBCUtil.disconnect(pstmt, conn);
	    }
	    System.out.println("member.MemberDAO.update 성공");
	    return true;
	}

	@Override
	public boolean delete(MemberDTO memberDTO) {
		System.out.println("member.MemberDAO.delete 시작");	
	    Connection conn = JDBCUtil.connect();
	    PreparedStatement pstmt = null;
	    try {
	    	// 회원탈퇴
	        pstmt = conn.prepareStatement(DELETE);
	        pstmt.setString(1, memberDTO.getMember_id());
			int rs = pstmt.executeUpdate();
			if(rs<=0) {
				System.err.println("member.MemberDAO.delete 실패");
				return false;
			}

		} catch (SQLException e) {
			System.err.println("member.MemberDAO.delete SQL문 실패");
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt,conn);
		}
		System.out.println("member.MemberDAO.delete 성공");
		return true;
	}

}

