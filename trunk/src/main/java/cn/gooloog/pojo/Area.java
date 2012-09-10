package cn.gooloog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_area", catalog = "joomtu")
public class Area implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5240236955370907399L;
	private Integer aid;
	private Integer pid;
	private Short order;
	private Integer lid;
	private Integer rid;
	private Short depth;
	private String name;

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(Integer pid, Short order, Integer lid, Integer rid,
			Short depth, String name) {
		this.pid = pid;
		this.order = order;
		this.lid = lid;
		this.rid = rid;
		this.depth = depth;
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "pid", nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "order", nullable = false)
	public Short getOrder() {
		return this.order;
	}

	public void setOrder(Short order) {
		this.order = order;
	}

	@Column(name = "lid", nullable = false)
	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	@Column(name = "rid", nullable = false)
	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Column(name = "depth", nullable = false)
	public Short getDepth() {
		return this.depth;
	}

	public void setDepth(Short depth) {
		this.depth = depth;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}