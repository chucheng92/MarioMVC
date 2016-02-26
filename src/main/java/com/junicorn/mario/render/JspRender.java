package com.junicorn.mario.render;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junicorn.mario.Const;
import com.junicorn.mario.Mario;
import com.junicorn.mario.MarioContext;

/**
 * JSP渲染实现
 * @author 哓哓
 *
 */
public class JspRender implements Render {

	@Override
	public void render(String view, Writer writer) {
		String viewPath = getViewPath(view);
		
		HttpServletRequest httpServletRequest = MarioContext.getMarioContext().getRequest().getRaw();
		HttpServletResponse httpServletResponse = MarioContext.getMarioContext().getResponse().getRaw();
		
		try {
			httpServletRequest.getRequestDispatcher(viewPath).forward(httpServletRequest, httpServletResponse);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getViewPath(String view) {
		Mario mario = Mario.getInstance();
		String viewPrefix = mario.getConf(Const.VIEW_PREFIX_FIELD);
		String viewSuffix = mario.getConf(Const.VIEW_SUFFIX_FIELD);
		
		if (null == viewPrefix || viewPrefix.equals("")) {
			viewPrefix = Const.VIEW_PREFIX;
		}
		
		if (null == viewSuffix || viewSuffix.equals("")) {
			viewSuffix = Const.VIEW_SUFFIX;
		}
		
		String viewPath = viewPrefix + "/" + view;
		if (!view.endsWith(viewSuffix)) {
			view += viewSuffix;
		}
		return viewPath.replaceAll("[/]+", "/");
	}
}
