package com.junicorn.mario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.junicorn.mario.route.Route;
import com.junicorn.mario.route.RouteMatcher;

public class MarioFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(MarioFilter.class.getName());
	
	private RouteMatcher routeMatcher = new RouteMatcher(new ArrayList<Route>());
	
	private ServletContext servletContext;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Mario mario = Mario.me();
		if (!mario.isInit) {
			
		}
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}