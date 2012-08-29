package com.joomtu.action;

import com.opensymphony.xwork2.ActionSupport;

//@Controller
public class HelloWorldAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4850145502824584196L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String test() {
		return "success";
	}
}