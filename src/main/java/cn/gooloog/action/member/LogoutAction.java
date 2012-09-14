package cn.gooloog.action.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1967232166388624215L;
	
	private Boolean cleanCookie = true;

	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();

		if (this.cleanCookie) {
			ActionContext context = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) context
					.get(ServletActionContext.HTTP_REQUEST);
			HttpServletResponse response = (HttpServletResponse) context
					.get(ServletActionContext.HTTP_RESPONSE);
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("USER_COOKIE".equals(cookie.getName())) {
						cookie.setValue("");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return SUCCESS;
	}

}
