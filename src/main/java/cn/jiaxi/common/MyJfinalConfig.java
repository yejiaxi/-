package cn.jiaxi.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;


import cn.jiaxi.common.handler.UrlHandler;
import cn.jiaxi.common.intercepter.GlobalInterceptor;
import cn.jiaxi.common.model._MappingKit;
public class MyJfinalConfig extends JFinalConfig {
	public static void main(String[] args) {
		/**
		 * webAppDir 表示项目的根路径
		 * port 端口号  
		 * context ：表示访问url中的项目名  如果为"/"时   url: loclhost/user/list
		 * 			 如果为"/jfinal" url: loclhost/jfinal/user/list
		 * 
		 * scanIntervalSeconds = 1:表示热启动时间  修改文件后 保存时 1秒后重启服务器，设置为0 或者
		 * 不设置该参数时  则不会有热启动
		 */
		JFinal.start("src/main/webapp", 80, "/",1);
		
		//JFinal.start(webAppDir, port, context, scanIntervalSeconds);
		
	}
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		
		//加载配置文件
		PropKit.use("cfg.txt");
		
		/*******常用配置********/
		
		/*loadPropertyFile("cfg.properties");//加载properties文件到框架中
		me.setDevMode(getPropertyToBoolean("devMode"));//设置DeBug模式
		me.setViewType(ViewType.JSP);//设置视图类型为JSP   默认为ViewType.JFINAL_TEMPLATE
		me.setError404View("404.html");//设置404错误页面
		me.setI18nDefaultBaseName("");//设置国际化资源根路径
		me.setBaseUploadPath(PathKit.getWebRootPath() + "/upload");//设置上传文件根路径
		me.setUrlParaSeparator("-");//设置url参数分割符  http://jiaxi/blog/1-3  1为文章id 3为分页页码
        */		
		
		/********************/
		
	}
	@Override
	public void configEngine(Engine arg0) {
		
		
	}
	//全局公共处理器的配置
	@Override
	public void configHandler(Handlers me) {
		//me.add(new UrlHandler()); 
	}
	//全局拦截器的配置
	@Override
	public void configInterceptor(Interceptors me) { 
		me.add(new GlobalInterceptor());
	}
	@Override
	public void configPlugin(Plugins me) {
		/*DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
		me.add(activeRecordPlugin);*/
		//_MappingKit.mapping(activeRecordPlugin);
		//me.add(new EhCachePlugin());  
	}
	@Override
	public void configRoute(Routes me) {
		//配置页面路径  
		me.add(new AdminRoutes());
		me.add(new FrontRouters());
		
	}
	
	@Override
	public void afterJFinalStart() {
		System.out.println("jfinal启动后自动启动调度线程");
	} 
	
	@Override
	public void beforeJFinalStop() {
		System.out.println("jfinal关闭时, 关闭调度线程");
	}
	
	
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("username"), PropKit.get("password"));
	}
}
