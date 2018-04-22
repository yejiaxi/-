package cn.jiaxi.common.intercepter;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GlobalInterceptor implements Interceptor {
	public void intercept(Invocation invocation) {
		System.out.println("全局拦截器前");
		invocation.invoke();
		System.out.println("全局拦截器后");
	}

}
