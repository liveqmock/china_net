package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.DBConnection;
import com.neusoft.vo.User;

public class UserDaoImpl implements UserDao {

	public User validateUser(String name, String password) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		
		String sql = "select * from rp_user_t where name=? and password=?";
		
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(name);
				user.setPassword(password);
				user.setAuth(rs.getInt("auth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pstmt,rs);
		}
		return user;
	}

	public void updatePass(String newpass, int id) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update rp_user_t set password=? where id=?";
		try {
			con=DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newpass);
			pstmt.setInt(2,id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pstmt);
		}
	}
	
	//添加用户
	public void addUser(String name, String password,String auth) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into rp_user_t(id,name,password,auth) values(seq_cnc.nextval,?,?,?)";
		
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, auth);
			
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
		
	}

	// 列出所有用户
	public List<User> getUser() throws Exception{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		User u=null;
		String sql="select * from rp_user_t where auth<>0";//修改页面不显示管理员
		List<User> userList=null;
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			userList=new ArrayList<User>();
			
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				/*if(rs.getInt("auth")==0){
					u.setAuthName("管理员");
				}else */
				if(rs.getInt("auth")==1){
					u.setAuthName("手工录入人员");
				}else if(rs.getInt("auth")==2){
					u.setAuthName("稽核人员");
				}else if(rs.getInt("auth")==3){
					u.setAuthName("归集人员");
				}
				userList.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, stmt,rs);
		}
		return userList;	
	}
	public void delUser(String id) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from rp_user_t where id=?";
		
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pstmt);
		}
	}
	public void updateUserById(String id, String password, String auth)
			throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update rp_user_t set password=?,auth=? where id=?";
		
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, auth);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pstmt);
		}
	}

}
