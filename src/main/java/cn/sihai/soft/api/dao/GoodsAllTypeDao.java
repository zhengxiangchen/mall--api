package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.sihai.soft.api.entity.GoodsAllTypeEntity;

public interface GoodsAllTypeDao extends JpaRepository<GoodsAllTypeEntity, Integer>{

	@Query("from GoodsAllTypeEntity where pid is null")
	ArrayList<GoodsAllTypeEntity> getFirst();

	@Query("from GoodsAllTypeEntity where pid = ?1")
	ArrayList<GoodsAllTypeEntity> getSecond(Integer integer);

	@Query("from GoodsAllTypeEntity where secondName like CONCAT('%',?1,'%')")
	ArrayList<GoodsAllTypeEntity> search(String name);

}
