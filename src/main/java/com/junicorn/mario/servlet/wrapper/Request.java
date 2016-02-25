package com.junicorn.mario.servlet.wrapper;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest增强
 * @author 哓哓
 *
 */
public class Request {
	
	private HttpServletRequest raw;
	
	public Request(HttpServletRequest httpServletRequest) {
		this.raw = httpServletRequest;
	}
	
	public HttpServletRequest getRaw() {
		return raw;
	}
	
	public void attr(String name, Object value) {
		raw.setAttribute(name, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T attr(String name) {
		Object value = raw.getAttribute(name);
		if (null != value) {
			return (T) value;
		}
		return null;
	}
	
	public String query(String name) {
		return raw.getParameter(name);
	}
}
