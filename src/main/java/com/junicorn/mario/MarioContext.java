package com.junicorn.mario;

import javax.servlet.ServletContext;

import com.junicorn.mario.servlet.wrapper.Request;
import com.junicorn.mario.servlet.wrapper.Response;

/**
 * 当前线程上下文环境
 * @author 哓哓
 *
 */
public class MarioContext {
	
	private static final ThreadLocal<MarioContext> Context = new ThreadLocal<>();
	
	private ServletContext servletContext;
	
	private Request request;
	
	private Response response;
	
	public MarioContext() {
	}
	
	public static MarioContext getMarioContext() {
		return Context.get();
	}
	
	public static void initContext(ServletContext servletContext, Request request, Response response) {
		MarioContext marioContext = new MarioContext();
		marioContext.servletContext = servletContext;
		marioContext.request = request;
		marioContext.response = response;
		Context.set(marioContext);
	}
	
	public static void remove() {
		Context.remove();
	}

	// ====================================
	// setters/getters
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
}
