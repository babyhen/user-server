package com.pawpaw.userserver.service;


import com.pawpaw.userserver.dao.UserAccountMapper;
import com.pawpaw.userserver.dao.entity.UserAccount;
import com.pawpaw.userserver.dao.entity.UserAccount.Gender;
import com.pawpaw.userserver.dao.entity.UserAccount.Type;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserAccountMapper userAccountMapper;


    public long registByMobile(Integer gender, String mobile, String nickName, Type type) {
        Assert.hasText(mobile, "手机号不能为空");
        UserAccount record = this.userAccountMapper.getByMobile(mobile);
        if (record != null) {
            this.userAccountMapper.updateStatusById(record.getUserId(), UserAccount.Status.NORMAL.value);
            return record.getUserId();
        }
        // 插入
        if (StringUtils.isBlank(nickName)) {
            nickName = "用户" + StringUtils.substring(mobile, -4, mobile.length());
        }
        UserAccount user = new UserAccount();
        user.setCreateTime(new Date());
        if (gender != null) {
            //验证枚举值合法性
            Gender.fromIntValue(gender);
            user.setGender(gender);
        }
        user.setMobile(mobile);
        user.setNickName(nickName);
        user.setSource(UserAccount.Source.PAWPAW.value);
        user.setStatus(UserAccount.Status.NORMAL.value);
        if (type == null) {
            type = Type.NORMAL;
        }
        user.setType(type.value);
        user.setUpdateTime(new Date());
        userAccountMapper.insert(user);
        long userId = user.getUserId();
        logger.info("增加了新用户,userid={}", userId);
        return userId;

    }


    public long registByOpenID(Integer gender, String weixinOpenId, String nickName, Type type) {
        Assert.hasText(weixinOpenId, "weixinOpenId不能为空");

        UserAccount record = this.userAccountMapper.getByWXOpenId(weixinOpenId);
        if (record != null) {
            // 更新状态
            this.userAccountMapper.updateStatusById(record.getUserId(), UserAccount.Status.NORMAL.value);
            return record.getUserId();
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
            Gender.fromIntValue(gender);
            user.setGender(gender);
        }
        user.setNickName(nickName);
        user.setSource(UserAccount.Source.WEIXIN.value);
        user.setStatus(UserAccount.Status.NORMAL.value);
        user.setType(type.value);
        user.setUpdateTime(new Date());
        user.setWeixinOpenId(weixinOpenId);
        userAccountMapper.insert(user);
        long userId = user.getUserId();
        logger.info("增加了新用户,userid={}", userId);
        return userId;

    }


    public void closeAccount(Long userId) {
        Assert.notNull(userId, "userID非法");
        UserAccount record = new UserAccount();
        this.userAccountMapper.updateStatusById(userId, UserAccount.Status.DELETE.value);
    }


}
