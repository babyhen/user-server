package com.pawpaw.fishinghome.usercenter.service;

import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Gender;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Type;

/**
 * 用户相关的serivce
 * 
 * @author liujixin
 *
 */
public interface IUserService {
	/**
	 * 通过手机号注册用户
	 * 
	 * @param source
	 * @param gender
	 * @param mobile
	 * @param nickName
	 * @param weixinOpenId
	 * @return
	 */
	public long createOrUpdateByMobile(Gender gender, String mobile, String nickName, Type type);

	/**
	 * 通过微信注册用户
	 * 
	 * @param source
	 * @param gender
	 * @param mobile
	 * @param nickName
	 * @param weixinOpenId
	 * @return
	 */
	public long createOrUpdateByOpenID(Gender gender, String weixinOpenId, String nickName, Type type);

	/**
	 * 注销账号
	 */
	public void closeAccount(long userID);
	
	
	/**
	 * 更新手机号
	 * @param userID
	 * @param mobile
	 */
	public void updateMobile(long userID,String mobile);
	
	
	
	
	

}