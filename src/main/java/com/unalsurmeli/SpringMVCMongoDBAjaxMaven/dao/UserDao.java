package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.dao;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.User;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ProcessResultUtil;

public interface UserDao {

	// public List<User> listUser() ;
	public ProcessResultUtil listUser();

	public ProcessResultUtil add(User user);

	public boolean update(User user);

	public boolean delete(User user);

	public ProcessResultUtil findUserById(String id);

	public boolean dropUserCollection();

}
