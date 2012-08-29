package com.joomtu.pojo;

// default package

import com.joomtu.pojo.Msg;
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
 * MsgInbox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_msg_inbox", catalog = "joomtu")
public class MsgInbox implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2931820954732474880L;
	private Long id;
	private User userByUid;
	private Msg jtMsg;
	private User userByFromUid;
	private String msgTitle;
	private Integer updateTime;
	private Boolean status;

	// Constructors

	/** default constructor */
	public MsgInbox() {
	}

	/** minimal constructor */
	public MsgInbox(User userByUid, Msg jtMsg, User userByFromUid,
			Integer updateTime) {
		this.userByUid = userByUid;
		this.jtMsg = jtMsg;
		this.userByFromUid = userByFromUid;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public MsgInbox(User userByUid, Msg jtMsg, User userByFromUid,
			String msgTitle, Integer updateTime, Boolean status) {
		this.userByUid = userByUid;
		this.jtMsg = jtMsg;
		this.userByFromUid = userByFromUid;
		this.msgTitle = msgTitle;
		this.updateTime = updateTime;
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
	@JoinColumn(name = "uid", nullable = false)
	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "msg_id", nullable = false)
	public Msg getJtMsg() {
		return this.jtMsg;
	}

	public void setJtMsg(Msg jtMsg) {
		this.jtMsg = jtMsg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_uid", nullable = false)
	public User getUserByFromUid() {
		return this.userByFromUid;
	}

	public void setUserByFromUid(User userByFromUid) {
		this.userByFromUid = userByFromUid;
	}

	@Column(name = "msg_title", length = 50)
	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	@Column(name = "update_time", nullable = false)
	public Integer getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}