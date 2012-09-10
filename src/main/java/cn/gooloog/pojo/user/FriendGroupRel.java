package cn.gooloog.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtFriendGroupRel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_friend_group_rel", catalog = "joomtu")
public class FriendGroupRel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5553957115038137487L;
	private Long id;
	private Integer gid;
	private Integer uid;
	private Integer addTime;
	private Boolean flag;
	private Boolean status;

	// Constructors

	/** default constructor */
	public FriendGroupRel() {
	}

	/** minimal constructor */
	public FriendGroupRel(Integer gid, Integer uid, Integer addTime) {
		this.gid = gid;
		this.uid = uid;
		this.addTime = addTime;
	}

	/** full constructor */
	public FriendGroupRel(Integer gid, Integer uid, Integer addTime,
			Boolean flag, Boolean status) {
		this.gid = gid;
		this.uid = uid;
		this.addTime = addTime;
		this.flag = flag;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "gid", nullable = false)
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "flag")
	public Boolean getFlag() {
		return this.flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}