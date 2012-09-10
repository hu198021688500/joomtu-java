package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtFriendGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_friend_group", catalog = "joomtu")
public class FriendGroup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2409754520065348787L;
	private Integer gid;
	private String name;
	private Integer count;
	private Integer createUid;
	private Integer createTime;
	private Boolean status;

	// Constructors

	/** default constructor */
	public FriendGroup() {
	}

	/** minimal constructor */
	public FriendGroup(String name, Integer createUid, Integer createTime) {
		this.name = name;
		this.createUid = createUid;
		this.createTime = createTime;
	}

	/** full constructor */
	public FriendGroup(String name, Integer count, Integer createUid,
			Integer createTime, Boolean status) {
		this.name = name;
		this.count = count;
		this.createUid = createUid;
		this.createTime = createTime;
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

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "create_uid", nullable = false)
	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	@Column(name = "create_time", nullable = false)
	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}