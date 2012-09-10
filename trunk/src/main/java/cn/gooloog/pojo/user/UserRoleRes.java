package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserRoleRes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_role_res", catalog = "joomtu")
public class UserRoleRes implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4341076360392931764L;
	private Integer id;
	private String path;
	private String description;

	// Constructors

	/** default constructor */
	public UserRoleRes() {
	}

	/** full constructor */
	public UserRoleRes(String path, String description) {
		this.path = path;
		this.description = description;
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

	@Column(name = "path", nullable = false, length = 50)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "description", nullable = false, length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}