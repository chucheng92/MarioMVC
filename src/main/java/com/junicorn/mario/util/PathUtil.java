package com.junicorn.mario.util;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

public class PathUtil {
	
	public static final String VAR_REGEX = ":(\\w+)";
	
	public static final String VAR_REPLACE = "([^#/?]+)";
	
	private static final String SLASH = "/";
	
	public static String getRelativePath(HttpServletRequest request) {
		String path = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		//TODO
		System.out.println("===========path=" + path);
		System.out.println("===========contextPath=" + contextPath);
		path = path.substring(contextPath.length());
		
		if (path.length() > 0) {
			path = path.substring(1);
		}
		
		if (!path.startsWith(SLASH)) {
			path = SLASH + path;
		}
		
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//TODO
		System.out.println("===========path=" + path);
		
		return path;
	}
	
	public static String fixPath(String path) {
		if (null == path) {
			return "/";
		}
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		if (path.length() > 1 && path.endsWith("/")) {
			path = path.substring(0, path.length()-1);
		}
		
		return path;
	}
	
	
	public static String cleanPath(String path) {
		if (null == path) {
			return null;
		}
		
		return path.replaceAll("[/]+", "/");
	}
}
