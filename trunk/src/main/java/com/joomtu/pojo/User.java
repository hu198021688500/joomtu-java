package com.joomtu.pojo;

// default package

import com.joomtu.bean.Gender;
import com.joomtu.pojo.FriendGroup;
import com.joomtu.pojo.FriendGroupRel;
import com.joomtu.pojo.MsgOutbox;
import com.joomtu.pojo.UserExt;
import com.joomtu.pojo.UserMerchantExt;
import com.joomtu.pojo.UserPhoto;
import com.joomtu.pojo.UserPhotoPic;
import com.joomtu.pojo.UserStoresExt;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_user", catalog = "joomtu")
@Searchable
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312083803308764817L;
	@SearchableId
	private Integer uid;
	private String email;
	@SearchableProperty(name = "password")
	private String password;
	private String salt;
	private String oldPassword;
	@SearchableProperty(name = "nickname")
	private String nickname;
	private Gender sex;
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
	private Set<MsgOutbox> MsgOutboxes = new HashSet<MsgOutbox>(0);
	private Set<FriendGroupRel> FriendGroupRels = new HashSet<FriendGroupRel>(0);
	private Set<FriendGroup> FriendGroups = new HashSet<FriendGroup>(0);
	private Set<UserMerchantExt> UserMerchantExts = new HashSet<UserMerchantExt>(
			0);
	private Set<UserPhotoPic> UserPhotoPics = new HashSet<UserPhotoPic>(0);
	private UserExt UserExt;
	private Set<UserStoresExt> UserStoresExts = new HashSet<UserStoresExt>(0);
	private Set<MsgInbox> msgInboxesForUid = new HashSet<MsgInbox>(0);
	private Set<UserPhoto> UserPhotos = new HashSet<UserPhoto>(0);
	private Set<MsgInbox> msgInboxesForFromUid = new HashSet<MsgInbox>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email, String password, String salt, String nickname,
			Gender sex, Short rid, Integer nid, Boolean status,
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
			String nickname, Gender sex, String avatar, String mobile,
			String birthday, String address, Short rid, Integer nid,
			Boolean status, String config, String signature, Integer integral,
			Integer regTime, String regIp, String regSource,
			Integer lastLoginTime, String lastLoginIp, Boolean loginFailTimes,
			Integer resetPwdTime, Integer updateTime,
			Set<MsgOutbox> MsgOutboxes, Set<FriendGroupRel> FriendGroupRels,
			Set<FriendGroup> FriendGroups,
			Set<UserMerchantExt> UserMerchantExts,
			Set<UserPhotoPic> UserPhotoPics, UserExt UserExt,
			Set<UserStoresExt> UserStoresExts, Set<MsgInbox> msgInboxesForUid,
			Set<UserPhoto> UserPhotos, Set<MsgInbox> msgInboxesForFromUid) {
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
		this.MsgOutboxes = MsgOutboxes;
		this.FriendGroupRels = FriendGroupRels;
		this.FriendGroups = FriendGroups;
		this.UserMerchantExts = UserMerchantExts;
		this.UserPhotoPics = UserPhotoPics;
		this.UserExt = UserExt;
		this.UserStoresExts = UserStoresExts;
		this.msgInboxesForUid = msgInboxesForUid;
		this.UserPhotos = UserPhotos;
		this.msgInboxesForFromUid = msgInboxesForFromUid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "uid", unique = true, nullable = false)
	//@Id @Column(name="uid", type="integer") @GeneratedValue(strategy="AUTO")
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
	public Gender getSex() {
		return this.sex;
	}

	public void setSex(Gender sex) {
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<MsgOutbox> getMsgOutboxes() {
		return this.MsgOutboxes;
	}

	public void setMsgOutboxes(Set<MsgOutbox> MsgOutboxes) {
		this.MsgOutboxes = MsgOutboxes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<FriendGroupRel> getFriendGroupRels() {
		return this.FriendGroupRels;
	}

	public void setFriendGroupRels(Set<FriendGroupRel> FriendGroupRels) {
		this.FriendGroupRels = FriendGroupRels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<FriendGroup> getFriendGroups() {
		return this.FriendGroups;
	}

	public void setFriendGroups(Set<FriendGroup> FriendGroups) {
		this.FriendGroups = FriendGroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserMerchantExt> getUserMerchantExts() {
		return this.UserMerchantExts;
	}

	public void setUserMerchantExts(Set<UserMerchantExt> UserMerchantExts) {
		this.UserMerchantExts = UserMerchantExts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserPhotoPic> getUserPhotoPics() {
		return this.UserPhotoPics;
	}

	public void setUserPhotoPics(Set<UserPhotoPic> UserPhotoPics) {
		this.UserPhotoPics = UserPhotoPics;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public UserExt getUserExt() {
		return this.UserExt;
	}

	public void setUserExt(UserExt UserExt) {
		this.UserExt = UserExt;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserStoresExt> getUserStoresExts() {
		return this.UserStoresExts;
	}

	public void setUserStoresExts(Set<UserStoresExt> UserStoresExts) {
		this.UserStoresExts = UserStoresExts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUid")
	public Set<MsgInbox> getMsgInboxesForUid() {
		return this.msgInboxesForUid;
	}

	public void setMsgInboxesForUid(Set<MsgInbox> msgInboxesForUid) {
		this.msgInboxesForUid = msgInboxesForUid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserPhoto> getUserPhotos() {
		return this.UserPhotos;
	}

	public void setUserPhotos(Set<UserPhoto> UserPhotos) {
		this.UserPhotos = UserPhotos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByFromUid")
	public Set<MsgInbox> getMsgInboxesForFromUid() {
		return this.msgInboxesForFromUid;
	}

	public void setMsgInboxesForFromUid(Set<MsgInbox> msgInboxesForFromUid) {
		this.msgInboxesForFromUid = msgInboxesForFromUid;
	}

}