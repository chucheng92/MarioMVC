package com.junicorn.mario.render;

import java.io.Writer;

/**
 * 视图渲染
 * @author 哓哓
 *
 */
public interface Render {
	
	/**
	 * 渲染到视图
	 * @param view		视图名称
	 * @param writer	写入对象
	 */
	public abstract void render(String view, Writer writer);
}
