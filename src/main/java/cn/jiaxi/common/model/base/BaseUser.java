package cn.jiaxi.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public M setUId(java.lang.String uId) {
		set("u_id", uId);
		return (M)this;
	}
	
	public java.lang.String getUId() {
		return getStr("u_id");
	}

	public M setUPassword(java.lang.String uPassword) {
		set("u_password", uPassword);
		return (M)this;
	}
	
	public java.lang.String getUPassword() {
		return getStr("u_password");
	}

	public M setUName(java.lang.String uName) {
		set("u_name", uName);
		return (M)this;
	}
	
	public java.lang.String getUName() {
		return getStr("u_name");
	}

	public M setUAge(java.lang.Integer uAge) {
		set("u_age", uAge);
		return (M)this;
	}
	
	public java.lang.Integer getUAge() {
		return getInt("u_age");
	}

	public M setUBirthday(java.util.Date uBirthday) {
		set("u_birthday", uBirthday);
		return (M)this;
	}
	
	public java.util.Date getUBirthday() {
		return get("u_birthday");
	}

}
