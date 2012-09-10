package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserRoleAccess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_role_access", catalog = "joomtu")
public class UserRoleAccess implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219167691685928866L;
	private Integer id;
	private Integer roleId;
	private Integer resId;
	private Integer isAllow;

	// Constructors

	/** default constructor */
	public UserRoleAccess() {
	}

	/** minimal constructor */
	public UserRoleAccess(Integer roleId, Integer resId) {
		this.roleId = roleId;
		this.resId = resId;
	}

	/** full constructor */
	public UserRoleAccess(Integer roleId, Integer resId, Integer isAllow) {
		this.roleId = roleId;
		this.resId = resId;
		this.isAllow = isAllow;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "role_id", nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "res_id", nullable = false)
	public Integer getResId() {
		return this.resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	@Column(name = "is_allow")
	public Integer getIsAllow() {
		return this.isAllow;
	}

	public void setIsAllow(Integer isAllow) {
		this.isAllow = isAllow;
	}

}