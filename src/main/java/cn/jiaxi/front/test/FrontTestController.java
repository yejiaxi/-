package cn.jiaxi.front.test;

import com.jfinal.core.Controller;

/**
 * 前台测试控制器
 *
 */
public class FrontTestController extends Controller {
	public void test(){
		this.setAttr("data", "前台测试页面");
		this.render("frontTest.html");
	}
}
