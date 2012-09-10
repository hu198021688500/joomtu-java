package cn.gooloog.action.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/user")
@Results({@Result(name = "login", location = "/WEB-INF/user/login.jsp") })
public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = -3072562238313805631L;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Action(value = "login", results = { @Result(name = "success", location = "/helloworld.jsp") })
	public String login() {
		System.out.println("Validating login");
		if (!this.getUsername().equals("Admin")
				|| !this.getPassword().equals("Admin")) {
			this.addActionError("Invalid user name or password! Please try again!");
			return ERROR;
		} else {
			return "success";
		}
	}

	@Override
	public String execute() throws Exception {
		return "login";
	}

}
