package cn.jiaxi.admin.user;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;

import cn.jiaxi.common.model.User;

public class UserService {
	static final User userDao = User.dao;
	//添加事务控制
	@Before(Tx.class)
	public void add(User user){
		user.save();
	}
	
	public List<User> list(){
		List<User> userList = userDao.find("select * from ct_user");
		return userList;
	}
}
