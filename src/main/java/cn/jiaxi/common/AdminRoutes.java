package cn.jiaxi.common;

import com.jfinal.config.Routes;

import cn.jiaxi.admin.user.UserController;
import cn.jiaxi.common.file.UploadController;
import cn.jiaxi.common.intercepter.AdminAuthInterceptor;

/**
 *后台路由，所有路由
 */
public class AdminRoutes extends Routes {
	@Override
	public void config() {
		//添加后台权限拦截器
		this.addInterceptor(new AdminAuthInterceptor());
		
		setBaseViewPath("/WEB-INF/page/admin/");
		this.add("/user", UserController.class,"user");
		this.add("/upload",UploadController.class);
	}
}
