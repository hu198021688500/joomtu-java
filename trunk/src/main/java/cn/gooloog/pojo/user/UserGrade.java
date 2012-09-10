package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserGrade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_grade", catalog = "joomtu")
public class UserGrade implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553052587790544804L;
	private Integer gid;
	private String name;
	private Boolean status;

	// Constructors

	/** default constructor */
	public UserGrade() {
	}

	/** full constructor */
	public UserGrade(String name, Boolean status) {
		this.name = name;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gid", unique = true, nullable = false)
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}