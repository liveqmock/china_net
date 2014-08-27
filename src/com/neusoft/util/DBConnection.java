package com.neusoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public static Connection getConnection() throws Exception{
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "userone", "pass");
		return con;
	}
	
	public static void close(Connection con,Statement stmt){
		try {
			if(stmt!=null)stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection con,Statement stmt,ResultSet rs){
		try {
			if(rs!=null)rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null)stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection con,PreparedStatement pstmt){
		try {
			if(pstmt!=null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection con,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs!=null)rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt!=null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
