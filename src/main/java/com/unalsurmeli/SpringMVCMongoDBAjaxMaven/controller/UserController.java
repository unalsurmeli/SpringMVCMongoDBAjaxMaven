package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.Result;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.UmpRequest;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model.User;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.service.UserService;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.EmptyUtil;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ProcessResultUtil;
import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ResultCodes;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/index" })
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView("/index");

		ProcessResultUtil listProcessResultUtil = userService.listUser();
		if (listProcessResultUtil.isSuccess()) {
			@SuppressWarnings("unchecked")
			List<User> listUser = (List<User>) listProcessResultUtil.getObject();
			model.addObject("listUser", listUser);
			return model;
		}
		return null;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("/index");

		ProcessResultUtil listProcessResultUtil = userService.listUser();
		if (listProcessResultUtil.isSuccess()) {
			@SuppressWarnings("unchecked")
			List<User> listUser = (List<User>) listProcessResultUtil.getObject();
			model.addObject("listUser", listUser);
			return model;
		}

		return null;
	}

	@RequestMapping(value = "/getUserAll", method = RequestMethod.POST)
	public @ResponseBody Result ajaxGetUserAll(@RequestBody UmpRequest umpRequest, HttpServletResponse response) {
		if (!"getUserAll".equalsIgnoreCase(umpRequest.getProcessName())) {
			return new Result(ResultCodes.UMPGUA001);
		}

		ProcessResultUtil listProcessResultUtil = userService.listUser();
		if (!listProcessResultUtil.isSuccess()) {
			return new Result(ResultCodes.UMPGUA002);
		}

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) listProcessResultUtil.getObject();
		Result result = new Result(ResultCodes.UMPC000);
		result.setListUser(listUser);
		return result;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Result ajaxInsert(@RequestBody User user, HttpServletResponse response) {
		if (user == null) {
			return new Result(ResultCodes.UMPI001);
		}

		ProcessResultUtil addProcessResultUtil = userService.add(user);
		if (!addProcessResultUtil.isSuccess()) {
			return new Result(ResultCodes.UMPI002);
		}

		return new Result(ResultCodes.UMPC000, addProcessResultUtil.getObject().toString());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result ajaxUpdate(@RequestBody User user, HttpServletResponse response) {
		if (user == null) {
			return new Result(ResultCodes.UMPU001);
		}

		if (!userService.update(user)) {
			return new Result(ResultCodes.UMPU002);
		}

		return new Result(ResultCodes.UMPC000);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result ajaxDelete(@RequestBody User requestUser, HttpServletResponse response) {

		if (EmptyUtil.isEmpty(requestUser)) {
			return new Result(ResultCodes.UMPD001);
		}

		if (EmptyUtil.isEmpty(requestUser.getId())) {
			return new Result(ResultCodes.UMPD001);
		}

		ProcessResultUtil listProcessResultUtil = userService.findUserById(requestUser.getId());
		if (!listProcessResultUtil.isSuccess()) {
			return new Result(ResultCodes.UMPD001);
		}

		User user = (User) listProcessResultUtil.getObject();

		if (EmptyUtil.isEmpty(user)) {
			return new Result(ResultCodes.UMPD001);
		}

		if (!userService.delete(user)) {
			return new Result(ResultCodes.UMPD002);
		}

		return new Result(ResultCodes.UMPC000);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	public @ResponseBody Result ajaxDeleteAll(@RequestBody UmpRequest umpRequest, HttpServletResponse response) {

		if (!"deleteAll".equalsIgnoreCase(umpRequest.getProcessName())) {
			return new Result(ResultCodes.UMPDA001);
		}

		if (!userService.dropUserCollection()) {
			return new Result(ResultCodes.UMPDA002);
		}

		return new Result(ResultCodes.UMPC000);
	}

}
