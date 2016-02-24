package com.junicorn.mario.util;

public class PathUtil {
	
	public static final String VAR_REGEX = ":(\\w+)";
	
	public static final String VAR_REPLACE = "([^#/?]+)";
	
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
