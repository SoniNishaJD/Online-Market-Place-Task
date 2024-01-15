package com.nishasoni.online.marketplace.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Helper {

	public static boolean checkAdminRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();

		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("ADMIN");
	}

	public static boolean checkUserRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();

		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("USER");
	}

	public static String getOrderNo(int id) {
		String pattern = "yyyyMMddHHmmssms";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		String ids = String.valueOf(10000+id);
		return date+"-"+ids;

	}
}
