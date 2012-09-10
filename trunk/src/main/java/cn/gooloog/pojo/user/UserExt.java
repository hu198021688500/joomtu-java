package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserExt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_ext", catalog = "joomtu")
public class UserExt implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4465386369897701947L;
	private Integer uid;
	private String reallyName;
	private String idNumber;
	private String qq;
	private Integer inviteuid;
	private String invitecode;
	private String activationcode;

	// Constructors

	/** default constructor */
	public UserExt() {
	}

	/** minimal constructor */
	public UserExt(Integer uid) {
		this.uid = uid;
	}

	/** full constructor */
	public UserExt(Integer uid, String reallyName, String idNumber,
			String qq, Integer inviteuid, String invitecode,
			String activationcode) {
		this.uid = uid;
		this.reallyName = reallyName;
		this.idNumber = idNumber;
		this.qq = qq;
		this.inviteuid = inviteuid;
		this.invitecode = invitecode;
		this.activationcode = activationcode;
	}

	// Property accessors
	@Id
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "really_name", length = 10)
	public String getReallyName() {
		return this.reallyName;
	}

	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}

	@Column(name = "ID_number", length = 18)
	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Column(name = "qq", length = 12)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "inviteuid")
	public Integer getInviteuid() {
		return this.inviteuid;
	}

	public void setInviteuid(Integer inviteuid) {
		this.inviteuid = inviteuid;
	}

	@Column(name = "invitecode", length = 32)
	public String getInvitecode() {
		return this.invitecode;
	}

	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode;
	}

	@Column(name = "activationcode", length = 32)
	public String getActivationcode() {
		return this.activationcode;
	}

	public void setActivationcode(String activationcode) {
		this.activationcode = activationcode;
	}

}