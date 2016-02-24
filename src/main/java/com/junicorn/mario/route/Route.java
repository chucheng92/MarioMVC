package com.junicorn.mario.route;

import java.lang.reflect.Method;

/**
 * 路由
 * @author 哓哓
 * 所有的请求在程序中是一个路由，匹配在path，
 * 执行靠action，处于controller中
 */
public class Route {
	/**
	 * 路由path
	 */
	private String path;
	
	/**
	 * 执行路由的方法
	 */
	private Method action;
	
	/**
	 * 路由所在的控制器
	 */
	private Object controller;
	
	/**
	 * 构造方法
	 */
	public Route() {

	} 

	// ===================================
	// getters/setters
	// ===================================
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Method getAction() {
		return action;
	}

	public void setAction(Method action) {
		this.action = action;
	}

	public Object getController() {
		return controller;
	}

	public void setController(Object controller) {
		this.controller = controller;
	}
	
}
