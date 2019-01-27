package com.pawpaw.userserver;


import com.pawpaw.userserver.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrap.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void registByMobile() {
        String mobile = "18810765135";
        int gender = 1;
        String nickName = "二逼";
        long userId = this.userService.registByMobile(gender, mobile, nickName, null);
        System.out.println(userId);
    }

    @Test
    public void registByOpenID() {
        String openId = "3333333";

        long userId = this.userService.registByOpenID(null, openId, null, null);
        System.out.println(userId);
    }

    @Test
    public void closeAccount() {
        this.userService.closeAccount(8L);

    }
}
