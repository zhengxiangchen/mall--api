package cn.sihai.soft.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 已失效
 * 创建人：Jarvan   
 * 创建时间：2018年11月14日 上午11:21:16
 */
@Entity
@Table(name = "mini_goods_type")
public class GoodsTypeEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "banner")
	private String banner;//图片地址
	
	@Column(name = "name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

