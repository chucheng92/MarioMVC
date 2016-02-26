package com.junicorn.mario;

import java.lang.reflect.Method;

import com.junicorn.mario.config.ConfigLoader;
import com.junicorn.mario.render.JspRender;
import com.junicorn.mario.render.Render;
import com.junicorn.mario.route.Routers;
import com.junicorn.mario.servlet.wrapper.Request;
import com.junicorn.mario.servlet.wrapper.Response;

/**
 * Mario单例
 * @author 哓哓
 * 添加路由
 * 读取资源文件
 * 读取配置
 * 渲染器等
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
	
	/**
	 * 渲染器
	 */
	private Render render;
	
	// ================================
	// Mario设置为uniqueMario单例全局对象
	private Mario() {
		routers = new Routers();
		configLoader = new ConfigLoader();
		render = new JspRender();
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
	
	/**
	 * 添加路由
	 * @param path			映射的path
	 * @param methodName	方法名称
	 * @param controller	控制器对象
	 * @return				返回Mario
	 */
	public Mario addRoute(String path, String methodName, Object controller) {
		try {
			Method method = controller.getClass().getMethod(methodName, Request.class, Response.class);
			this.routers.addRoute(path, method, controller);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return this;
	}

	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}
	
 }
