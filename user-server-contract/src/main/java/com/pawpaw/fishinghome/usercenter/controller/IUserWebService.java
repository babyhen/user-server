package com.pawpaw.fishinghome.usercenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawpaw.fishinghome.usercenter.controller.vo.RegistUserResp;

@RequestMapping(value = "/user")
public interface IUserWebService {
	/**
	 * 通过手机号注册用户
	 * 
	 * @param gender
	 * @param mobile
	 * @param nickName
	 * @return
	 */
	@RequestMapping(value = "/registUserByMobile")
	public RegistUserResp registUserByMobile(@RequestParam(value = "gender", required = false) Integer gender, //
			@RequestParam("mobile") String mobile, //
			@RequestParam(value = "nickName", required = false) String nickName);

	/**
	 * 通过微信的openID注册
	 * 
	 * @param gender
	 * @param openID
	 * @param nickName
	 * @return
	 */
	@RequestMapping("/createOrUpdateByOpenID")
	public RegistUserResp createOrUpdateByOpenID(@RequestParam(value = "gender", required = false) Integer gender, //
			@RequestParam("openID") String openID, //
			@RequestParam(value = "nickName", required = false) String nickName);

	/**
	 * 注销账号
	 * 
	 * @param userID
	 */
	@RequestMapping("/closeAccount")
	public void closeAccount(@RequestParam("userID") long userID);

	/**
	 * 更新账户手机号
	 * 
	 * @param userID
	 * @param mobile
	 */
	@RequestMapping(value = "/updateMobile")
	public void updateMobile(@RequestParam("userID") long userID, @RequestParam("mobile") String mobile);

}
