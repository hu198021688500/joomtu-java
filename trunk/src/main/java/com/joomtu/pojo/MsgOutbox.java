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
 * JtMsgOutbox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_msg_outbox", catalog = "joomtu")
public class MsgOutbox implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8589828378192053921L;
	private Long id;
	private User user;
	private Msg jtMsg;
	private String toUid;
	private String msgTitle;
	private Boolean sendType;
	private Integer groupId;
	private Integer sendTime;
	private Boolean status;

	// Constructors

	/** default constructor */
	public MsgOutbox() {
	}

	/** minimal constructor */
	public MsgOutbox(User user, Msg jtMsg, Integer sendTime) {
		this.user = user;
		this.jtMsg = jtMsg;
		this.sendTime = sendTime;
	}

	/** full constructor */
	public MsgOutbox(User user, Msg jtMsg, String toUid, String msgTitle,
			Boolean sendType, Integer groupId, Integer sendTime, Boolean status) {
		this.user = user;
		this.jtMsg = jtMsg;
		this.toUid = toUid;
		this.msgTitle = msgTitle;
		this.sendType = sendType;
		this.groupId = groupId;
		this.sendTime = sendTime;
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
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "msg_id", nullable = false)
	public Msg getJtMsg() {
		return this.jtMsg;
	}

	public void setJtMsg(Msg jtMsg) {
		this.jtMsg = jtMsg;
	}

	@Column(name = "to_uid", length = 65535)
	public String getToUid() {
		return this.toUid;
	}

	public void setToUid(String toUid) {
		this.toUid = toUid;
	}

	@Column(name = "msg_title", length = 50)
	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	@Column(name = "send_type")
	public Boolean getSendType() {
		return this.sendType;
	}

	public void setSendType(Boolean sendType) {
		this.sendType = sendType;
	}

	@Column(name = "group_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "send_time", nullable = false)
	public Integer getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Integer sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}