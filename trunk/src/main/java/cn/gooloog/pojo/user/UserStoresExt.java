package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserStoresExt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_stores_ext", catalog = "joomtu")
public class UserStoresExt implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2174136726207581532L;
	private Integer sid;
	private Integer uid;

	// Constructors

	/** default constructor */
	public UserStoresExt() {
	}

	/** full constructor */
	public UserStoresExt(Integer uid) {
		this.uid = uid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}