package cn.gooloog.action.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.neo4j.rest.graphdb.entity.RestNode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import cn.gooloog.neo4j.Neo4jService;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;

public class UserAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7585120305255235862L;

	private static Log log = LogFactory.getLog(UserAction.class);

	private String email;

	@Resource
	private UserService userService;

	@Resource
	private Neo4jService neo4jService;

	private HttpServletRequest request;

	@RequiredStringValidator(key = "email_require", shortCircuit = true, trim = true)
	@EmailValidator(key = "email_format_error", shortCircuit = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	@SkipValidation
	public String index() {
		HttpServletRequest request1 = ServletActionContext.getRequest();

		System.out.println("request1:" + request1.getParameter("uid"));
		System.out.println("request:" + request.getParameter("uid"));

		String uidStr = request.getParameter("uid");
		Long uid = ("".equals(uidStr) || uidStr == null) ? 1 : Long
				.parseLong(uidStr);

		User user = userService.find(uid);
		System.out.println("Email:" + user.getEmail());

		RestNode node = neo4jService.getOrCreateNodeByUID(uid);
		if (null != node) {
			System.out.println("neo4j Email:" + node.getProperty("email"));
		}

		ActionContext.getContext().put("user", user);

		log.debug(user.getEmail());
		return "success";
	}

	/**
	 * 找回密码
	 * 
	 * @return
	 */
	public String findPass() {
		System.out.println(this.getEmail());
		return INPUT;
	}
}