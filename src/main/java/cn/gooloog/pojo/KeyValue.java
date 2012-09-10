package cn.gooloog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JtKeyValue entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jt_key_value", catalog = "joomtu")
public class KeyValue implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5476721441544320022L;
	private Integer id;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public KeyValue() {
	}

	/** minimal constructor */
	public KeyValue(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public KeyValue(Integer id, String key, String value) {
		this.id = id;
		this.key = key;
		this.value = value;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "key", length = 15)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "value", length = 65535)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}