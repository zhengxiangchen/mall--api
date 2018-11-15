package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.sihai.soft.api.entity.GoodsEntity;

public interface GoodsDao extends JpaRepository<GoodsEntity, Integer> {

	@Query("from GoodsEntity where goodsSecondTypeId = ?1")
	ArrayList<GoodsEntity> findBySecondType(String goodsSecondTypeId);

	@Query(nativeQuery=true, value = "select * from mini_goods order by id desc, goods_name desc limit ?1")
	ArrayList<GoodsEntity> getIndexList(Integer num);

	@Query("from GoodsEntity where goodsName like CONCAT('%',?1,'%')")
	ArrayList<GoodsEntity> search(String name);

}
