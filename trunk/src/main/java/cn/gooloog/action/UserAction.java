package cn.gooloog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.gooloog.neo4j.Neo4jService;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;
import cn.gooloog.util.MD5;

@Controller
@Namespace("/user")
public class UserAction implements ServletRequestAware {

	private static Log log = LogFactory.getLog(UserAction.class);

	@Resource
	private UserService userService;

	private HttpServletRequest request;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.request = req;
	}

	public String register() {
		if (user != null) {
			user.setPassword(MD5.MD5Encode(user.getPassword()));
			userService.save(user);
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
		HttpServletRequest request1 = ServletActionContext.getRequest();
		System.out.println("request1:" + request1.getParameter("uid"));

		System.out.println("request:" + request.getParameter("uid"));

		Long uid = request.getParameter("uid") == "" ? 1 : Long
				.parseLong(request.getParameter("uid"));
		
		User user = userService.find(uid);
		Neo4jService neo4jService = new Neo4jService();
		ActionContext.getContext().put("user", user);
		System.out.println("Email:" + user.getEmail());
		//System.out.println("neo4j Email:" + node.getProperty("email"));
		log.debug(user.getEmail());
		return "success";
	}
}