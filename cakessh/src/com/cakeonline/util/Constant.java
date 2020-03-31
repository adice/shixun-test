package com.cakeonline.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	public final static int STUDENT_STATE_NORMAL = 1;
	public final static int STUDENT_STATE_GRATU = 2;
	
	public static Map<String,String>emailUrl=new HashMap<String,String>(0);
	static {
		emailUrl.put("163.com", "http://mail.163.com");
		emailUrl.put("126.com", "http://mail.126.com");
		emailUrl.put("year.net", "http://mail.yeah.net");
		emailUrl.put("sohu.com", "http://login.mail.sohu.com/login.jsp");
		emailUrl.put("tom.com", "http://mail.tom.com");
		emailUrl.put("21cn.com", "http://mail.21cn.com");
		emailUrl.put("sina.com", "http://mail.sina.com.cn");
		emailUrl.put("sina.cn", "http://mail.tom.com");
		emailUrl.put("qq.com", "https://mail.qq.com");
		emailUrl.put("gmail.com", "https://www.google.com/accounts/ServiceLoginAuth");
	}

}
