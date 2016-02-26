package com.junicorn.mario.route;

import org.junit.Test;

import com.junicorn.mario.util.PathUtil;

public class RouteMatcherTest {
	
	@Test
	public void testMatchesPath() {
		System.out.println(matchesPath("/users/:uid23123321:dd", "/users/2"));
	}
	
	private boolean matchesPath(String routePath, String pathToMatch) {
		routePath = routePath.replaceAll(PathUtil.VAR_REGEX, PathUtil.VAR_REPLACE);
		
		System.out.println(routePath);
		
		return pathToMatch.matches("(?i)" + routePath); 
	}
}
