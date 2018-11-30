package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.service;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.User;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ProcessResultUtil;

public interface UserService {
	public ProcessResultUtil listUser();

	public ProcessResultUtil add(User user);

	public boolean update(User user);

	public boolean delete(User user);

	public ProcessResultUtil findUserById(String id);
	
	public boolean dropUserCollection();
}
