package com.junicorn.mario;

import java.lang.reflect.Method;

import com.junicorn.mario.config.ConfigLoader;
import com.junicorn.mario.route.Routers;

/**
 * Mario
 * @author 哓哓
 * 添加路由
 * 读取资源文件
 * 读取配置
 */
public class Mario {
	
	/**
	 * 存放所有路由
	 */
	private Routers routers;
	
	/**
	 * 配置加载器
	 */
	private ConfigLoader configLoader;
	
	/**
	 * 框架是否已经初始化
	 */
	private boolean init = false;
	
	// ================================
	// Mario设置为uniqueMario单例全局对象
	private Mario() {
		routers = new Routers();
		configLoader = new ConfigLoader();
	}
	
	private static class MarioHolder {
		private static final Mario uniqueMario = new Mario(); 
	}
	
	public static final Mario getInstance() {
		return MarioHolder.uniqueMario;
	}
	
	// ==================================
	
	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	/**
	 * 加载配置
	 * @param conf
	 * @return
	 */
	public Mario addConf(String conf) {
		configLoader.load(conf);
		return this;
	}
	
	/**
	 * 获取配置
	 * @param name
	 * @return
	 */
	public String getConf(String name) {
		return configLoader.getConf(name);
	}
	
	/**
	 * 载入路由
	 * @param routers
	 * @return
	 */
	public Mario addRoutes(Routers routers) {
		this.routers.addRoute(routers.getRoutes());
		return this;
	}
	
	/**
	 * 取得路由管理器
	 * @return
	 */
	public Routers getRouters() {
		return routers;
	}
	
	public Mario addRoute(String path, String methodName, Object controller) {
		Method method = controller.getClass().getMethod(methodName, Request.class, Response)
	}
 }
