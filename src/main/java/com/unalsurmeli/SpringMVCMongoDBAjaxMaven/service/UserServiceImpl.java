package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.dao.UserDao;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.User;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ProcessResultUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public ProcessResultUtil listUser() {
		return userDao.listUser();
	}

	public ProcessResultUtil add(User user) {
		return userDao.add(user);
	}

	public boolean update(User user) {
		return userDao.update(user);
	}

	public boolean delete(User user) {
		return userDao.delete(user);
	}

	public ProcessResultUtil findUserById(String id) {
		return userDao.findUserById(id);
	}

	public boolean dropUserCollection() {
		return userDao.dropUserCollection();
	}
}
