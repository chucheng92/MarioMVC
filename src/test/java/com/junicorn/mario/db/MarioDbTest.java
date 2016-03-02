package com.junicorn.mario.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MarioDbTest {
	public static void main(String[] args) {
		try {
			// 解决tomcat下报错
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MarioDb.init("jdbc:mysql://127.0.0.1:3306/mario_sample", "root", "root");

//		testGet();
//		testGet2();
//		 testGetList();
		 testGetList2();
//		testGetMap();
	}

	//  带参get测试
	public static void testGet() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "rose");
		User user = MarioDb.get("select * from t_user where name = :name", User.class, map);
		System.out.println(user);
	}

	// 无参get测试
	public static void testGet2() {
		User user = MarioDb.get("select * from t_user", User.class);
		System.out.println(user);
	}

	// 无参getList测试
	public static void testGetList() {
		List<User> list = MarioDb.getList("select * from t_user", User.class);

		for (User u : list) {
			System.out.println(u);
		}
	}
	
	// 带参getList带参
	public static void testGetList2() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "rose");
		map.put("id", 2);
		List<User> list = MarioDb.getList("select * from t_user where name = :name || id = :id", User.class, map);

		for (User u : list) {
			System.out.println(u);
		}
	}
	
	public static void testGetMap() {
		Map<String, Object> map = MarioDb.getMap("select * from t_user");
		
		System.out.println("=====");
	}
}
