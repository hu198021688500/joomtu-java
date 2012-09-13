package cn.gooloog.action.user;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.gooloog.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Namespace("/user")
@ParentPackage("user")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -3072562238313805631L;

	private String email;

	private String password;
	
	private Boolean remember;
	
	@Resource
	private UserService userService;

	@RequiredStringValidator(message = "Supply name")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@RequiredStringValidator(message = "Supply password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRemember() {
		return remember;
	}

	public void setRemember(Boolean remember) {
		this.remember = remember;
	}

	@Override
	@Action(value = "login", results = {
			@Result(name = "success", location = "/WEB-INF/user/loginSuccess.jsp"),
			@Result(name = "input", location = "/WEB-INF/user/login.jsp"),
			@Result(name = "error", location = "/WEB-INF/user/login.jsp") })
	public String execute() throws Exception {
		System.out.println("Validating login");
		if (!userService.login(this.email, this.password, this.remember)) {
			this.addFieldError("password", "Invalid user name or password! Please try again!");
			//this.addActionError("Invalid user name or password! Please try again!");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
}
