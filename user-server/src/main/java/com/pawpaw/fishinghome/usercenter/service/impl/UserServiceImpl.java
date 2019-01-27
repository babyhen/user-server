package com.pawpaw.fishinghome.usercenter.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.pawpaw.common.cache.CleanCache;
import com.pawpaw.common.cache.KeyMember;
import com.pawpaw.fishinghome.usercenter.dao.UserAccountMapper;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccount;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Gender;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Source;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Status;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum.Type;
import com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountExample;
import com.pawpaw.fishinghome.usercenter.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private static final String KEY_USER_PREFIX = "UserCenter:UserInfo:";
	@Autowired
	private UserAccountMapper userAccountMapper;

	@Override
	@CleanCache(key = KEY_USER_PREFIX, keyIncludeReturnValue = true)
	public long createOrUpdateByMobile(Gender gender, String mobile, String nickName, Type type) {
		Assert.hasText(mobile, "手机号不能为空");
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andMobileEqualTo(mobile);
		List<UserAccount> isExist = this.userAccountMapper.selectByExample(example);
		// 变更状态，不修改任何属性
		if (!CollectionUtils.isEmpty(isExist)) {
			UserAccount record = isExist.get(0);
			record.setStatus(Status.NORMAL.intValue());
			record.setUpdateTime(new Date());
			this.userAccountMapper.updateByPrimaryKeySelective(record);
			long userId = record.getUserId();
			logger.info("更新了用户,{}", userId);
			return userId;
		}
		// 插入
		if (StringUtils.isBlank(nickName)) {
			nickName = "用户" + StringUtils.substring(mobile, -4, mobile.length());
		}
		UserAccount user = new UserAccount();
		user.setCreateTime(new Date());
		if (gender != null) {
			user.setGender(gender.intValue());
		}
		user.setMobile(mobile);
		user.setNickName(nickName);
		user.setSource(Source.PAWPAW.intValue());
		user.setStatus(Status.NORMAL.intValue());
		if (type == null) {
			type = Type.NORMAL;
		}
		user.setType(type.intValue());
		user.setUpdateTime(new Date());
		userAccountMapper.insert(user);
		long userId = user.getUserId();
		logger.info("增加了新用户,userid={}", userId);
		return userId;

	}

	@Override
	@CleanCache(key = KEY_USER_PREFIX, keyIncludeReturnValue = true)
	public long createOrUpdateByOpenID(Gender gender, String weixinOpenId, String nickName, Type type) {
		Assert.hasText(weixinOpenId, "weixinOpenId不能为空");
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andWeixinOpenIdEqualTo(weixinOpenId);
		List<UserAccount> isExist = this.userAccountMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(isExist)) {
			// 更新状态
			UserAccount record = isExist.get(0);
			record.setStatus(Status.NORMAL.intValue());
			record.setUpdateTime(new Date());
			this.userAccountMapper.updateByPrimaryKeySelective(record);
			long userId = record.getUserId();
			logger.info("更新了用户,{}", userId);
			return userId;
		}
		if (StringUtils.isBlank(nickName)) {
			nickName = "用户" + StringUtils.substring(weixinOpenId, -4, weixinOpenId.length());
		}
		if (type == null) {
			type = Type.NORMAL;
		}

		// 插入
		UserAccount user = new UserAccount();
		user.setCreateTime(new Date());
		if (gender != null) {
			user.setGender(gender.intValue());
		}
		user.setNickName(nickName);
		user.setSource(Source.WEIXIN.intValue());
		user.setStatus(Status.NORMAL.intValue());
		user.setType(type.intValue());
		user.setUpdateTime(new Date());
		user.setWeixinOpenId(weixinOpenId);
		userAccountMapper.insert(user);
		long userId = user.getUserId();
		logger.info("增加了新用户,userid={}", userId);
		return userId;

	}

	@Override
	@CleanCache(key = KEY_USER_PREFIX)
	public void closeAccount(@KeyMember long userID) {
		Assert.state(userID > 0, "userID非法");
		UserAccount record = new UserAccount();
		record.setUserId(userID);
		record.setStatus(Status.DELETE.intValue());
		int row = this.userAccountMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@CleanCache(key = KEY_USER_PREFIX)
	public void updateMobile(@KeyMember long userID, String mobile) {
		Assert.state(userID > 0, "userID非法");
		Assert.hasText(mobile, "手机号不能为空");
		UserAccount record = new UserAccount();
		record.setUserId(userID);
		record.setMobile(mobile);
		int row = this.userAccountMapper.updateByPrimaryKeySelective(record);

	}
}
