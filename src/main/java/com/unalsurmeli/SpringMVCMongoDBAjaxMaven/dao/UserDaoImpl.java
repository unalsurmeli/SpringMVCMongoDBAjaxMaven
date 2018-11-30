package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.User;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ProcessResultUtil;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String TAG_collectionName = "USER";

	public ProcessResultUtil listUser() {
		try {
			List<User> list = mongoTemplate.findAll(User.class, TAG_collectionName);
			return new ProcessResultUtil(true, "", list);
		} catch (Exception e) {
			return new ProcessResultUtil(true, e.getMessage(), null);
		}
	}

	public ProcessResultUtil add(User user) {
		try {
			if (!mongoTemplate.collectionExists(User.class)) {
				mongoTemplate.createCollection(User.class);
			}
			user.setId(UUID.randomUUID().toString());
			mongoTemplate.insert(user, TAG_collectionName);
			return new ProcessResultUtil(true, "", user.getId());
		} catch (Exception e) {
			return new ProcessResultUtil(false, e.getMessage(), null);
		}
	}

	public boolean update(User user) {
		try {
			mongoTemplate.save(user, TAG_collectionName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(User user) {
		try {
			mongoTemplate.remove(user, TAG_collectionName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ProcessResultUtil findUserById(String id) {
		try {
			User user = mongoTemplate.findById(id, User.class, TAG_collectionName);
			return new ProcessResultUtil(true, "", user);
		} catch (Exception e) {
			return new ProcessResultUtil(true, e.getMessage(), null);
		}
	}

	public boolean dropUserCollection() {
		try {
			mongoTemplate.dropCollection(TAG_collectionName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
