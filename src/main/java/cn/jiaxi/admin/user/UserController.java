package cn.jiaxi.admin.user;

import java.util.List;

import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import cn.jiaxi.common.model.User;

/**
 * 1.控制器必须继承Jfinal中的Controller
 *
 */
public class UserController extends Controller {
	static final UserService userService = Enhancer.enhance(UserService.class);
	
	public void add(){
		User user = new User();
		user.setUId(StrKit.getRandomUUID());
		user.setUName("zhangsan");
		user.setUPassword("123456");
		userService.add(user);
		renderJson(Ret.ok());
		//获取前台传入参数  封装成对象 
		// this.getModel(User.class, "user");
	}
	public void list(){
		List<User> list = userService.list();
		Ret ret = Ret.ok().set("data", list);
		renderJson(ret);
	}	
	
	public void test(){
		this.setAttr("data", "后台测试页面");
		this.render("adminTest.html");
	}
}
