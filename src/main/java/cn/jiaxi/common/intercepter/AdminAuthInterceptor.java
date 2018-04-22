package cn.jiaxi.common.intercepter;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
/**
 * 后台权限拦截器
 * 暂时做成最简单的判断当前用户是否是管理员账号，后续改成完善的
 * 基于用户、角色、权限的权限管理系统，并且实现角色、权限完全动态化配置
 */
public class AdminAuthInterceptor implements Interceptor {
	public void intercept(Invocation invocation) {
		//获取用户权限  
		System.out.println("后台权限拦截器开始.....");
		invocation.invoke();
		System.out.println("后台权限拦截器结束.....");
	}
	
}
