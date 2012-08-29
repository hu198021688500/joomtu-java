package com.joomtu.bean;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.joomtu.pojo.User;
import com.joomtu.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Controller
public class UserAction {

	@Resource
	UserService userService;
	/**
	 * 
	 */
	private User user;

	/**
	 * 
	 */
	private String queryString;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString
	 *            the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * 
	 * @return
	 */
	public String register() {
		if (user == null || "".equals(user)) {
			return "registerUI";
		} else {
			userService.save(user);
			System.out.print(user.getSex());
			ActionContext.getContext().put("message", "保存成功");
			return "registerMessage";
		}
	}

	/**
	 * 
	 * @return
	 */
	public String list() {
		ActionContext.getContext().put("users", userService.list());
		return "list";
	}

	/**
	 * 
	 * @return
	 */
	public String search() {
		List<User> results = userService.searchUsers(queryString);
		ActionContext.getContext().put("searchresults", results);
		System.out.println(results.size());
		return "success";
	}
}
