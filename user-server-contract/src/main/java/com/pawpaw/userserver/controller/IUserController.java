package com.pawpaw.userserver.controller;

import com.pawpaw.userserver.controller.vo.RegistUserResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient("user-server")
@RequestMapping(value = "/user")
public interface IUserController {
    /**
     * 通过手机号注册用户
     *
     * @param gender
     * @param mobile
     * @param nickName
     * @return
     */
    @PostMapping(value = "/registByMobile")
    public RegistUserResp registByMobile(@RequestParam(value = "gender", required = false) Integer gender, //
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
    @RequestMapping("/registByOpenId")
    public RegistUserResp registByOpenID(@RequestParam(value = "gender", required = false) Integer gender, //
                                         @RequestParam("openID") String openID, //
                                         @RequestParam(value = "nickName", required = false) String nickName);

    /**
     * 注销账号
     *
     * @param userId
     */
    @RequestMapping("/closeAccount")
    public void closeAccount(@RequestParam("userId") long userId);


}
