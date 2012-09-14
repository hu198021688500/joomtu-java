package cn.gooloog.action.member;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.gooloog.config.Constants;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;
import cn.gooloog.util.DESPlus;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -3072562238313805631L;

	private String email;

	private String password;

	private Boolean remember;
	
	private String returnUrl;

	@Resource
	private UserService userService;

	@RequiredStringValidator(key = "email_require", shortCircuit = true, trim = true)
	@EmailValidator(key = "email_format_error", shortCircuit = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@RequiredStringValidator(message = "Supply password", shortCircuit = true, trim = true)
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

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Validating login");
		User user = userService.login(this.email, this.password);

		if (null != user) {
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();

			HttpServletResponse response = (HttpServletResponse) context
					.get(ServletActionContext.HTTP_RESPONSE);

			session.put(Constants.IN_SESSION_LOGIN_FLAG, true);
			session.put("nickname", user.getNickname());

			if (this.remember) {
				DESPlus des = new DESPlus(Constants.CRYPT_KEY);
				Cookie cookie = new Cookie("USER_COOKIE", des.encrypt(user
						.getEmail()) + "," + des.encrypt(user.getPassword()));
				cookie.setMaxAge(60 * 60 * 24 * 14);
				response.addCookie(cookie);
			}

			if (null != this.returnUrl && !this.returnUrl.trim().isEmpty()) {
				response.sendRedirect(this.returnUrl);
			} else if (null != session.get("return_url")
					&& !session.get("return_url").toString().trim().isEmpty()) {
				response.sendRedirect(session.get("return_url").toString());
			} else {
				response.sendRedirect("/index.jsp");
			}
			return SUCCESS;
		} else {
			this.addFieldError("password", "用户名或者密码不正确，请重试！");
			return INPUT;
		}
	}
}
