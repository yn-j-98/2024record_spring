package com.yn.app.biz.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yn.app.biz.common.JDBCUtil;

@Repository
public class ImageDAO {
	private final String SELECTONE = "SELECT IMAGEID, PATH, BID FROM IMAGE WHERE BID=? ORDER BY IMAGEID DESC LIMIT 1";
	private final String INSERT = "INSERT INTO IMAGE (PATH,BID) VALUES(?,?)";

	public List<ImageDTO> selectAll(ImageDTO imageDTO) {
		return null;
	}
	public ImageDTO selectOne(ImageDTO imageDTO){
		ImageDTO data=null;
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(SELECTONE);
			pstmt.setInt(1, imageDTO.getBid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new ImageDTO();
				data.setImageid(rs.getInt("IMAGEID"));
				data.setPath(rs.getString("PATH"));
				data.setBid(rs.getInt("BID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;

	}
	public boolean insert(ImageDTO imageDTO) {
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, imageDTO.getPath());
			pstmt.setInt(2, imageDTO.getBid());
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
	public boolean update(ImageDTO imageDTO) {
		return false;
	}
	public boolean delete(ImageDTO imageDTO) {
		return false;
	}

}
