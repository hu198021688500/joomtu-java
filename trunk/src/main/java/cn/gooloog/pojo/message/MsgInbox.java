package cn.gooloog.pojo.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtMsgInbox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_msg_inbox", catalog = "joomtu")
public class MsgInbox implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1425026637027212646L;
	private Long id;
	private Integer uid;
	private Integer fromUid;
	private Integer msgId;
	private String msgTitle;
	private Integer updateTime;
	private Boolean status;

	// Constructors

	/** default constructor */
	public MsgInbox() {
	}

	/** minimal constructor */
	public MsgInbox(Integer uid, Integer fromUid, Integer msgId,
			Integer updateTime) {
		this.uid = uid;
		this.fromUid = fromUid;
		this.msgId = msgId;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public MsgInbox(Integer uid, Integer fromUid, Integer msgId,
			String msgTitle, Integer updateTime, Boolean status) {
		this.uid = uid;
		this.fromUid = fromUid;
		this.msgId = msgId;
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

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "from_uid", nullable = false)
	public Integer getFromUid() {
		return this.fromUid;
	}

	public void setFromUid(Integer fromUid) {
		this.fromUid = fromUid;
	}

	@Column(name = "msg_id", nullable = false)
	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
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