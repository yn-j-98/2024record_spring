package com.koreait.app.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.koreait.app.biz.common.JDBCUtil;
 
@Repository
public class MemberDAO implements MemberService{
	
	private final String SQL_ALL = "SELECT MEMBER_NUM, MEMBER_ID, MEMBER_PASSWORD, MEMBER_DATE, MEMBER_ROLE FROM MEMBER";
	private final String SQL_ONE = "SELECT MEMBER_NUM, MEMBER_ID, MEMBER_PASSWORD, MEMBER_DATE, MEMBER_ROLE FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";
	private final String SQL_INSERT = "";
	private final String SQL_UPDATE = "";
	private final String SQL_DELETE = "";
	
	@Autowired
	private MemberDTO member;
	
	@Override
	public List<MemberDTO> SelectAll(MemberDTO memberDTO) {
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt=null;
		List<MemberDTO> datas = new ArrayList<>();
		try {
				pstmt=conn.prepareStatement(SQL_ALL);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					this.member = new MemberDTO();
					this.member.setMember_num(rs.getInt("MEMBER_NUM"));
					this.member.setMember_id(rs.getString("MEMBER_ID"));
					this.member.setMember_password(rs.getString("MEMBER_PASSWORD"));
					this.member.setMember_date(rs.getString("MEMBER_DATE"));
					this.member.setMember_role(rs.getBoolean("MEMBER_ROLE"));
					datas.add(this.member);
				}
		} catch (SQLException e) {
			System.out.println("SQL문 실패");
		}
		JDBCUtil.disconnect(pstmt,conn);
		return datas;
	}

	@Override
	public MemberDTO SelectOne(MemberDTO memberDTO) {
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt=null;
		try {
				pstmt=conn.prepareStatement(SQL_ONE);
				System.out.println(memberDTO.getMember_id());
				pstmt.setString(1, memberDTO.getMember_id());
				System.out.println(memberDTO.getMember_password());
				pstmt.setString(2, memberDTO.getMember_password());				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					this.member.setMember_num(rs.getInt("MEMBER_NUM"));
					this.member.setMember_id(rs.getString("MEMBER_ID"));
					this.member.setMember_password(rs.getString("MEMBER_PASSWORD"));
					this.member.setMember_date(rs.getString("MEMBER_DATE"));
					this.member.setMember_role(rs.getBoolean("MEMBER_ROLE"));
				}
		} catch (SQLException e) {
			System.out.println("SQL문 실패");
		}
		JDBCUtil.disconnect(pstmt,conn);
		return this.member;
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		return false;
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		return false;
	}

	@Override
	public boolean delete(MemberDTO memberDTO) {
		return false;
	}


>>>>>>> branch 'main' of https://github.com/yn-j-98/2024record_spring.git
}
