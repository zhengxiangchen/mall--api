package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sihai.soft.api.entity.GoodsEntity;

public interface GoodsDao extends CrudRepository<GoodsEntity, Integer> {

	@Query("from GoodsEntity where goodsSecondTypeId = ?")
	ArrayList<GoodsEntity> findBySecondType(String goodsSecondTypeId);

	@Query(nativeQuery=true, value = "select * from mini_goods order by id desc, goods_name desc limit ?")
	ArrayList<GoodsEntity> getIndexList(Integer num);

	@Query("from GoodsEntity where goodsName like CONCAT('%',?,'%')")
	ArrayList<GoodsEntity> search(String name);

}
