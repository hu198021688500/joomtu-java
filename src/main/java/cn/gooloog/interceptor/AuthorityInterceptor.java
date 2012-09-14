package cn.gooloog.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.gooloog.action.member.LoginAction;
import cn.gooloog.config.Constants;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;
import cn.gooloog.util.DESPlus;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5597731729888281513L;

	@Resource
	private UserService userService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("begin check login interceptor!");
		Object action = invocation.getAction();
		if (action instanceof LoginAction) {
			System.out
					.println("exit check login, because this is login action.");
			return invocation.invoke();
		}
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		Boolean loginFlag = (Boolean) session
				.get(Constants.IN_SESSION_LOGIN_FLAG);
		if (loginFlag != null && loginFlag) {
			System.out.println("already login!");
			return invocation.invoke();
		} else {
			System.out.println("no login, forward login page!");

			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			Cookie[] cookies = request.getCookies();
			System.out.println("cookies: " + cookies);
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("USER_COOKIE".equals(cookie.getName())) {
						String value = cookie.getValue();
						if (null != value) {
							String[] split = value.split(",");
							if (split.length == 2) {
								String username = split[0];
								String password = split[1];
								DESPlus des = new DESPlus(Constants.CRYPT_KEY);
								User user = userService.login(
										des.decrypt(username),
										des.decrypt(password));
								if (user != null) {
									session.put(
											Constants.IN_SESSION_LOGIN_FLAG,
											true);
									session.put("nickname", user.getNickname());
									return invocation.invoke();
								}
							}
						}
					}
				}
			}

			ctx.put("tip", "你还没有登录");
			session.put("return_url", this.getGoingURL());
			return Action.LOGIN;
		}
	}

	private String getGoingURL() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getHeader("Referer");
		if (url == null || url.trim().isEmpty()) {
			url = request.getContextPath() + request.getServletPath();
			String queryString = request.getQueryString();
			System.out.println(queryString);
			if (null != queryString && !queryString.trim().isEmpty()) {
				url = url + "?" + request.getQueryString();
			}
		}
		return url;
	}
}