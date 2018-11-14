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
@Table(name = "mini_goods_second_type")
public class GoodsSecondTypeEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "banner")
	private String banner;
	
	@Column(name = "firstType_id")
	private String firstTypeId;
	
	@Column(name = "indexImg")
	private String indexImg;
	
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

	public String getFirstTypeId() {
		return firstTypeId;
	}

	public void setFirstTypeId(String firstTypeId) {
		this.firstTypeId = firstTypeId;
	}

	public String getIndexImg() {
		return indexImg;
	}

	public void setIndexImg(String indexImg) {
		this.indexImg = indexImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

