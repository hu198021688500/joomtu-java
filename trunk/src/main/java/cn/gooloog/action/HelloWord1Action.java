package cn.gooloog.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 @Namespace("/member")
 @ParentPackage("user")
 @ResultPath("/WEB-INF/user")
 @Results({ @Result(name = "success", location = "/main.jsp"),
 @Result(name = "error", location = "/error.jsp") })
 @ExceptionMappings({ @ExceptionMapping(exception = "java.lang.NullPointerException", result = "success", params = {
 "param1", "val1" }) })
 @InterceptorRefs({ @InterceptorRef("interceptor-1"),
 @InterceptorRef("defaultStack") })*/
public class HelloWord1Action extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3412412563736846808L;

	private String username;

	private String password;

	// @RequiredStringValidator(message = "Supply name")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// @RequiredStringValidator(message = "Supply password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	// @Actions({ @Action("/different/url"), @Action("/another/url") })
	public String execute() throws Exception {
		System.out.println("Validating login");
		if (!this.getUsername().equals("Admin")
				|| !this.getPassword().equals("Admin")) {
			this.addActionError("Invalid user name or password! Please try again!");
			return ERROR;
		} else {
			return "success";
		}
	}

	// @Actions({ @Action("common1"), @Action("common2") })
	public String common() {
		return "success";
	}

	// @Action(value = "test", results = { @Result(name = "success", location =
	// "/WEB-INF/user/loginSuccess.jsp", type = "redirect") })
	public String test7() {
		return "success";
	}

	// @Action(interceptorRefs = @InterceptorRef(value = "validation", params =
	// {
	// "programmatic", "false", "declarative", "true" }))
	public String test6() {
		return "success";
	}

	// @Action(interceptorRefs = { @InterceptorRef("validation"),
	// @InterceptorRef("defaultStack") })
	public String test5() {
		return "success";
	}

	// @Action(value = "test4", results = { @Result(name = "success", location =
	// "http://struts.apache.org", type = "redirect") })
	public String test4() {
		return "success";
	}

	// @Action(value = "testx/test2", results = { @Result(name = "success", type
	// = "httpheader", params = {
	// "status", "500", "errorMessage", "Internal Error" }) })
	public String test2() {
		return "success";
	}

	// @Action("url")
	public String test3() {
		return "success";
	}

	// @Action(value = "test1", exceptionMappings = {
	// @ExceptionMapping(exception = "java.lang.NullPointerException", result =
	// "success", params = {
	// "param1", "val1" }) })
	public String test1() throws Exception {
		return null;
	}
}
