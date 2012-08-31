package cn.gooloog.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.gooloog.pojo.User;
import cn.gooloog.service.UserService;
import cn.gooloog.util.MD5;

@Controller
@Namespace("/user")
public class UserAction {

	@Resource
	private UserService service;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String register() {
		if (user != null) {
			user.setPassword(MD5.MD5Encode(user.getPassword()));
			service.save(user);
			ActionContext.getContext().put("message", "保存成功");
			return "registerMessage";
		} else {
			return "input";
		}
	}

	public String login() {
		return "success";
	}

	@Action(value = "test", results = { @Result(name = "success", location = "/helloworld.jsp") })
	public String test() {
		User user = service.find(1);
		ActionContext.getContext().put("user", user);
		System.out.println("Email:" + user.getEmail());
		return "success";
	}
}
