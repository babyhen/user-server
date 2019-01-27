package com.pawpaw.fishinghome.usercenter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.pawpaw.common.util.HttpUtil;

public class ControllerTest {

	private String hostport = "http://localhost:7080";

	@Test
	public void registUserByMobile() throws Exception {
		String url = hostport + "/user/registUserByMobile";
		Map<String, String> data = new HashMap<>();
		data.put("gender", "1");
		data.put("mobile", "18810765133");
		data.put("nickName", "阿毛");
		String resp=HttpUtil.postFormData(url, data);
		System.out.println(resp);
	}
}