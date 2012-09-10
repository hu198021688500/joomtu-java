package cn.gooloog.pojo.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
	private static final long serialVersionUID = 3033033906848526056L;
	private Long id;
	private Integer uid;
	private String toUid;
	private Integer msgId;
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
	public MsgOutbox(Integer uid, Integer msgId, Integer sendTime) {
		this.uid = uid;
		this.msgId = msgId;
		this.sendTime = sendTime;
	}

	/** full constructor */
	public MsgOutbox(Integer uid, String toUid, Integer msgId,
			String msgTitle, Boolean sendType, Integer groupId,
			Integer sendTime, Boolean status) {
		this.uid = uid;
		this.toUid = toUid;
		this.msgId = msgId;
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

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "to_uid", length = 65535)
	public String getToUid() {
		return this.toUid;
	}

	public void setToUid(String toUid) {
		this.toUid = toUid;
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