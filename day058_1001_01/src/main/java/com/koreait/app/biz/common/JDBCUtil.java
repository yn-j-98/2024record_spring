package com.koreait.app.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String driverName="com.mysql.cj.jdbc.Driver";
<<<<<<< HEAD
	private static final String url="jdbc:mysql://localhost:3306/kim";
=======
	private static final String url="jdbc:mysql://localhost:3306/yena";
>>>>>>> branch 'main' of https://github.com/yn-j-98/2024record_spring.git
	private static final String userName="root";
	private static final String password="1234";
	
	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		
		try {
			conn=DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.out.println("conn 연결 실패");
		}
		return conn;
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();	
		} catch (SQLException e) {
			System.out.println("연결 해제 실패");
		}		
	}
}
