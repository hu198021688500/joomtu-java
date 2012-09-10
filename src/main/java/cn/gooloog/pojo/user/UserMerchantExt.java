package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserMerchantExt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_merchant_ext", catalog = "joomtu")
public class UserMerchantExt implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3612858574895405502L;
	private Integer mid;
	private Integer uid;

	// Constructors

	/** default constructor */
	public UserMerchantExt() {
	}

	/** full constructor */
	public UserMerchantExt(Integer uid) {
		this.uid = uid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "mid", unique = true, nullable = false)
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}