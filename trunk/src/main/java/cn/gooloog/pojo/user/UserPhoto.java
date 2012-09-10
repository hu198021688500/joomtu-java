package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserPhoto entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_photo", catalog = "joomtu")
public class UserPhoto implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4239742654564963180L;
	private Integer pid;
	private Integer uid;

	// Constructors

	/** default constructor */
	public UserPhoto() {
	}

	/** full constructor */
	public UserPhoto(Integer uid) {
		this.uid = uid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pid", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}