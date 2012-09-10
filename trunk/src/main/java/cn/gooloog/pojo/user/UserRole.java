package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtUserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_user_role", catalog = "joomtu")
public class UserRole implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7404056087980809533L;
	private Short rid;
	private String prid;
	private String name;
	private String showName;
	private String description;
	private Integer createTime;
	private Integer updateTime;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(String name, Integer createTime, Integer updateTime) {
		this.name = name;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserRole(String prid, String name, String showName,
			String description, Integer createTime, Integer updateTime) {
		this.prid = prid;
		this.name = name;
		this.showName = showName;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rid", unique = true, nullable = false)
	public Short getRid() {
		return this.rid;
	}

	public void setRid(Short rid) {
		this.rid = rid;
	}

	@Column(name = "prid", length = 65535)
	public String getPrid() {
		return this.prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "show_name", length = 10)
	public String getShowName() {
		return this.showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "create_time", nullable = false)
	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", nullable = false)
	public Integer getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

}