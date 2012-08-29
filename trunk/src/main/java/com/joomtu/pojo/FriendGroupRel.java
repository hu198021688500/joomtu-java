package com.joomtu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private static final long serialVersionUID = -1808778866099609777L;
	private Long id;
	private FriendGroup jtFriendGroup;
	private User user;
	private Integer addTime;
	private Boolean flag;
	private Boolean status;

	// Constructors

	/** default constructor */
	public FriendGroupRel() {
	}

	/** minimal constructor */
	public FriendGroupRel(FriendGroup jtFriendGroup, User user, Integer addTime) {
		this.jtFriendGroup = jtFriendGroup;
		this.user = user;
		this.addTime = addTime;
	}

	/** full constructor */
	public FriendGroupRel(FriendGroup jtFriendGroup, User user,
			Integer addTime, Boolean flag, Boolean status) {
		this.jtFriendGroup = jtFriendGroup;
		this.user = user;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gid", nullable = false)
	public FriendGroup getJtFriendGroup() {
		return this.jtFriendGroup;
	}

	public void setJtFriendGroup(FriendGroup jtFriendGroup) {
		this.jtFriendGroup = jtFriendGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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