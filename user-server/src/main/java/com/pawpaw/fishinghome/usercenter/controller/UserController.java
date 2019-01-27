package com.pawpaw.fishinghome.usercenter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pawpaw.fishinghome.usercenter.controller.vo.RegistUserResp;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Gender;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Type;
import com.pawpaw.fishinghome.usercenter.service.IUserService;

@RestController
public class UserController implements IUserWebService {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Override
	public RegistUserResp registUserByMobile(Integer gender, String mobile, String nickName) {
		Gender g = null;
		if (gender != null) {
			g = Gender.fromIntValue(gender);
		}
		long userId = userService.createOrUpdateByMobile(g, mobile, nickName, Type.NORMAL);
		return new RegistUserResp(userId);
	}

	@Override
	public RegistUserResp createOrUpdateByOpenID(@RequestParam(value = "gender", required = false) Integer gender, //
			@RequestParam("openID") String openID, //
			@RequestParam(value = "nickName", required = false) String nickName) {
		Gender g = null;
		if (gender != null) {
			g = Gender.fromIntValue(gender);
		}
		long userId = userService.createOrUpdateByOpenID(g, openID, nickName, Type.NORMAL);
		return new RegistUserResp(userId);
	}

	@Override
	public void closeAccount(@RequestParam("userID") long userID) {

		this.userService.closeAccount(userID);
	}

	@Override
	public void updateMobile(@RequestParam("userID") long userID, @RequestParam("mobile") String mobile) {
		this.userService.updateMobile(userID, mobile);

	}

}
