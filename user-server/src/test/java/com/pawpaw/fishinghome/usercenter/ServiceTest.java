package com.pawpaw.fishinghome.usercenter;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pawpaw.fishinghome.usercenter.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrap.class)
public class ServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void createOrUpdateByMobile() {
		long userId = this.userService.createOrUpdateByMobile(null, "18810765133", null, null);
		System.out.println(userId);
	}

	@Test
	public void createOrUpdateByOpenID() {
		long userId = this.userService.createOrUpdateByOpenID(null, "gjdlkjaljglajglajglajlgkjlaeg", null, null);
		System.out.println(userId);
	}

	@Test
	public void relectTest() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<?>[] c = new Class[4];
		c[0] = Class.forName("com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum$Gender");
		c[1] = String.class;
		c[2] = String.class;
		c[3] = Class.forName("com.pawpaw.fishinghome.usercenter.dao.entity.UserAccountEnum$Type");
		Method m = this.userService.getClass().getMethod("createOrUpdateByMobile", c);
		

	}
}
