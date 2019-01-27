package com.pawpaw.userserver.controller;

import com.pawpaw.userserver.controller.vo.RegistUserResp;
import com.pawpaw.userserver.dao.entity.UserAccount.Type;
import com.pawpaw.userserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UserController implements IUserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Override
    public RegistUserResp registByMobile(Integer gender, String mobile, String nickName) {

        long userId = userService.registByMobile(gender, mobile, nickName, Type.NORMAL);
        return new RegistUserResp(userId);
    }

    @Override
    public RegistUserResp registByOpenID(Integer gender, String openID, String nickName) {

        long userId = userService.registByOpenID(gender, openID, nickName, Type.NORMAL);
        return new RegistUserResp(userId);
    }

    @Override
    public void closeAccount(long userId) {
        this.userService.closeAccount(userId);
    }


}
