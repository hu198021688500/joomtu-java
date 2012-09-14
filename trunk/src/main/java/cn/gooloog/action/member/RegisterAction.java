package cn.gooloog.action.member;

import javax.annotation.Resource;

import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3175597034411154485L;

	private String email;
	
	private String password;
	
	private String repasssword;
	
	private String nickname;
	
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

	@RequiredStringValidator(key = "password_require", shortCircuit = true, trim = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@RequiredStringValidator(key = "repassword_require", shortCircuit = true, trim = true)
	public String getRepasssword() {
		return repasssword;
	}

	public void setRepasssword(String repasssword) {
		this.repasssword = repasssword;
	}

	@RequiredStringValidator(key = "nickname_require", shortCircuit = true, trim = true)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setEmail(this.email);
		user.setPassword(this.password);
		user.setNickname(this.nickname);
		user = userService.register(user);
		if (null == user) {
			return INPUT;
		}
		return SUCCESS;
	}
}
