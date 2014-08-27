package com.neusoft.dao;

import java.util.List;

import com.neusoft.vo.User;


public interface UserDao {

	public User validateUser(String name, String password)throws Exception;
	
	public void updatePass(String newpass,int id)throws Exception;

	public void addUser(String name, String password, String auth) throws Exception;

	public List<User> getUser() throws Exception;

	public void delUser(String id)throws Exception;
	
	public void updateUserById(String id,String password,String auth)throws Exception;

}
