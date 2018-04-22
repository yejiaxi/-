package cn.jiaxi.common;

import com.jfinal.config.Routes;

import cn.jiaxi.front.test.FrontTestController;

/**
 * 1.前台页面路由，所有前端的路由配置在这个路由里面
 */
public class FrontRouters extends Routes{

	@Override
	public void config() {
		//配置页面路径
		setBaseViewPath("/WEB-INF/page/front/");
		this.add("/front", FrontTestController.class,"/test");
	}
	
}
