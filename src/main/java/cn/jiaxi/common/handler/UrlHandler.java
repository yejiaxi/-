package cn.jiaxi.common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
/**
 * 自定义handler在系统内置actionHandler之前执行
 * 因此自定以handler可以做一些action之前的拦截处理  
 * 
 * 例如可以对url进行处理   只有后缀是html的url才能访问
 *
 */
public class UrlHandler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		System.out.println(target);
		if(target.endsWith(".html")){
			target = target.substring(0, target.indexOf(".html"));
		}
		next.handle(target , request, response, isHandled);
	}
	
}
