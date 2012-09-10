package cn.gooloog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtMenuAdmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_menu_admin", catalog = "joomtu")
public class MenuAdmin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2597368137535086859L;
	private Integer id;
	private Integer pid;
	private Short order;
	private Integer lid;
	private Integer rid;
	private Short depth;
	private String name;
	private String url;
	private Boolean status;

	// Constructors

	/** default constructor */
	public MenuAdmin() {
	}

	/** full constructor */
	public MenuAdmin(Integer pid, Short order, Integer lid, Integer rid,
			Short depth, String name, String url, Boolean status) {
		this.pid = pid;
		this.order = order;
		this.lid = lid;
		this.rid = rid;
		this.depth = depth;
		this.name = name;
		this.url = url;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Column(name = "url", nullable = false, length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}