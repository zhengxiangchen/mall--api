package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sihai.soft.api.entity.GoodsSecondTypeEntity;

/**
 * 已失效
 * 创建人：Jarvan   
 * 创建时间：2018年11月14日 上午11:21:16
 */
public interface GoodsSecondTypeDao extends CrudRepository<GoodsSecondTypeEntity, Integer> {

	
	@Query("from GoodsSecondTypeEntity where firstTypeId = ?")
	ArrayList<GoodsSecondTypeEntity> findByFirstType(String id);

	@Query("from GoodsSecondTypeEntity where name like CONCAT('%',?,'%')")
	ArrayList<GoodsSecondTypeEntity> search(String name);

}
