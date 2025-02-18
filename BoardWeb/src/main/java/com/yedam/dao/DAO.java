package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	// Connection 객체. StateMent, PreparedStatement, ResultSet
	Connection conn = null;
	Statement stmt; //query 실행 후 결과 반환 Class
	PreparedStatement psmt;
	ResultSet rs;

	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클DB의 접속정보
		String user = "hr";
		String password = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}// end of getConnect()
}
