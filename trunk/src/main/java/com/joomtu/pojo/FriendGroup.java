package com.joomtu.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private static final long serialVersionUID = -7088297921367650780L;
	private Integer gid;
	private User user;
	private String name;
	private Integer count;
	private Integer createTime;
	private Boolean status;
	private Set<FriendGroupRel> jtFriendGroupRels = new HashSet<FriendGroupRel>(
			0);

	// Constructors

	/** default constructor */
	public FriendGroup() {
	}

	/** minimal constructor */
	public FriendGroup(User user, String name, Integer createTime) {
		this.user = user;
		this.name = name;
		this.createTime = createTime;
	}

	/** full constructor */
	public FriendGroup(User user, String name, Integer count,
			Integer createTime, Boolean status,
			Set<FriendGroupRel> jtFriendGroupRels) {
		this.user = user;
		this.name = name;
		this.count = count;
		this.createTime = createTime;
		this.status = status;
		this.jtFriendGroupRels = jtFriendGroupRels;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "create_uid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jtFriendGroup")
	public Set<FriendGroupRel> getJtFriendGroupRels() {
		return this.jtFriendGroupRels;
	}

	public void setJtFriendGroupRels(Set<FriendGroupRel> jtFriendGroupRels) {
		this.jtFriendGroupRels = jtFriendGroupRels;
	}

}