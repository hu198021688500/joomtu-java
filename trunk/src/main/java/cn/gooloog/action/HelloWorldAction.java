package cn.gooloog.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/helloworld")
public class HelloWorldAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6809295670812588746L;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String test() {
		return "success";
	}

	@Action(value = "test1", results = {
			@Result(name = "success", location = "/helloworld.jsp"),
			@Result(name = "error", location = "/helloworld.jsp") })
	public String test1() {
		return "success";
	}

}