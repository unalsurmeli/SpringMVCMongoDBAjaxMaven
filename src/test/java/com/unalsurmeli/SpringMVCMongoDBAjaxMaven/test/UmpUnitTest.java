package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.config.WebConfig;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.User;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.service.UserService;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ProcessResultUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class })
@WebAppConfiguration
public class UmpUnitTest {

	@Autowired
	UserService userService;

	@Test
	public void UmpTest() {
		User user = new User();
		user.setFirstName("Ünal");
		user.setLastName("Sürmeli");
		user.setPhone("05557777776");
		user.setEmail("test@test.com");

		ProcessResultUtil addProcessResultUtil = userService.add(user);

		assertEquals(true, addProcessResultUtil.isSuccess());

		ProcessResultUtil listProcessResultUtil = userService.listUser();
		assertEquals(true, listProcessResultUtil.isSuccess());

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) listProcessResultUtil.getObject();
		for (int i = 0; i < listUser.size(); i++) {
			System.out.println(listUser.get(0).getFirstName() + " " + listUser.get(0).getLastName());
		}

		ProcessResultUtil findProcessResultUtil = userService.findUserById(addProcessResultUtil.getObject().toString());
		assertEquals(true, findProcessResultUtil.isSuccess());

		User userTwo = (User) findProcessResultUtil.getObject();

		assertEquals(true, userService.delete(userTwo));

		User userThree = new User();
		userThree.setFirstName("Ünal3");
		userThree.setLastName("Sürmeli3");
		userThree.setPhone("05557777773");
		userThree.setEmail("test@test3.com");

		assertEquals(true, userService.update(userThree));

		// assertEquals(true, userService.dropUserCollection());
	}

}
