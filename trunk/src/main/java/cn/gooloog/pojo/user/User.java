package cn.gooloog.pojo.user;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user", catalog = "joomtu")
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2326813636016117676L;
	private Integer uid;
	private String email;
	private String password;
	private String salt;
	private String oldPassword;
	private String nickname;
	private Boolean sex;
	private String avatar;
	private String mobile;
	private String birthday;
	private String address;
	private Short rid;
	private Integer nid;
	private Boolean status;
	private String config;
	private String signature;
	private Integer integral;
	private Integer regTime;
	private String regIp;
	private String regSource;
	private Integer lastLoginTime;
	private String lastLoginIp;
	private Boolean loginFailTimes;
	private Integer resetPwdTime;
	private Integer updateTime;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email, String password, String salt, String nickname,
			Boolean sex, Short rid, Integer nid, Boolean status,
			Integer integral, Integer regTime, Boolean loginFailTimes,
			Integer resetPwdTime, Integer updateTime) {
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.sex = sex;
		this.rid = rid;
		this.nid = nid;
		this.status = status;
		this.integral = integral;
		this.regTime = regTime;
		this.loginFailTimes = loginFailTimes;
		this.resetPwdTime = resetPwdTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public User(String email, String password, String salt, String oldPassword,
			String nickname, Boolean sex, String avatar, String mobile,
			String birthday, String address, Short rid, Integer nid,
			Boolean status, String config, String signature, Integer integral,
			Integer regTime, String regIp, String regSource,
			Integer lastLoginTime, String lastLoginIp, Boolean loginFailTimes,
			Integer resetPwdTime, Integer updateTime) {
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.oldPassword = oldPassword;
		this.nickname = nickname;
		this.sex = sex;
		this.avatar = avatar;
		this.mobile = mobile;
		this.birthday = birthday;
		this.address = address;
		this.rid = rid;
		this.nid = nid;
		this.status = status;
		this.config = config;
		this.signature = signature;
		this.integral = integral;
		this.regTime = regTime;
		this.regIp = regIp;
		this.regSource = regSource;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.loginFailTimes = loginFailTimes;
		this.resetPwdTime = resetPwdTime;
		this.updateTime = updateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "email", nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", nullable = false, length = 15)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "old_password", length = 32)
	public String getOldPassword() {
		return this.oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@Column(name = "nickname", nullable = false, length = 15)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "sex", nullable = false)
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "avatar")
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "birthday", length = 12)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "rid", nullable = false)
	public Short getRid() {
		return this.rid;
	}

	public void setRid(Short rid) {
		this.rid = rid;
	}

	@Column(name = "nid", nullable = false)
	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "config", length = 10)
	public String getConfig() {
		return this.config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	@Column(name = "signature", length = 50)
	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "integral", nullable = false)
	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Column(name = "reg_time", nullable = false)
	public Integer getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Integer regTime) {
		this.regTime = regTime;
	}

	@Column(name = "reg_ip", length = 16)
	public String getRegIp() {
		return this.regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	@Column(name = "reg_source", length = 5)
	public String getRegSource() {
		return this.regSource;
	}

	public void setRegSource(String regSource) {
		this.regSource = regSource;
	}

	@Column(name = "last_login_time")
	public Integer getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Integer lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "last_login_ip", length = 16)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "login_fail_times", nullable = false)
	public Boolean getLoginFailTimes() {
		return this.loginFailTimes;
	}

	public void setLoginFailTimes(Boolean loginFailTimes) {
		this.loginFailTimes = loginFailTimes;
	}

	@Column(name = "reset_pwd_time", nullable = false)
	public Integer getResetPwdTime() {
		return this.resetPwdTime;
	}

	public void setResetPwdTime(Integer resetPwdTime) {
		this.resetPwdTime = resetPwdTime;
	}

	@Column(name = "update_time", nullable = false)
	public Integer getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

}