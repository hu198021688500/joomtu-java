package cn.gooloog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtMenuCat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_menu_cat", catalog = "joomtu")
public class MenuCat implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -297112252972958683L;
	private Integer cid;

	// Constructors

	/** default constructor */
	public MenuCat() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}