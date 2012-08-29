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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JtMsg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_msg", catalog = "joomtu")
public class Msg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1836704512765077823L;
	private Integer mid;
	private String title;
	private String content;
	private Boolean status;
	private Set<MsgOutbox> jtMsgOutboxes = new HashSet<MsgOutbox>(0);
	private Set<MsgInbox> msgInboxes = new HashSet<MsgInbox>(0);

	// Constructors

	/** default constructor */
	public Msg() {
	}

	/** minimal constructor */
	public Msg(String title, String content) {
		this.title = title;
		this.content = content;
	}

	/** full constructor */
	public Msg(String title, String content, Boolean status,
			Set<MsgOutbox> jtMsgOutboxes, Set<MsgInbox> msgInboxes) {
		this.title = title;
		this.content = content;
		this.status = status;
		this.jtMsgOutboxes = jtMsgOutboxes;
		this.msgInboxes = msgInboxes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "mid", unique = true, nullable = false)
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jtMsg")
	public Set<MsgOutbox> getJtMsgOutboxes() {
		return this.jtMsgOutboxes;
	}

	public void setJtMsgOutboxes(Set<MsgOutbox> jtMsgOutboxes) {
		this.jtMsgOutboxes = jtMsgOutboxes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jtMsg")
	public Set<MsgInbox> getMsgInboxes() {
		return this.msgInboxes;
	}

	public void setMsgInboxes(Set<MsgInbox> msgInboxes) {
		this.msgInboxes = msgInboxes;
	}

}