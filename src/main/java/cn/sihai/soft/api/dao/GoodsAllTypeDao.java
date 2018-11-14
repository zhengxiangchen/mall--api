package cn.sihai.soft.api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.sihai.soft.api.entity.GoodsAllTypeEntity;

public interface GoodsAllTypeDao extends CrudRepository<GoodsAllTypeEntity, Integer>{

	@Query("from GoodsAllTypeEntity where pid is null")
	ArrayList<GoodsAllTypeEntity> getFirst();

	@Query("from GoodsAllTypeEntity where pid = ?")
	ArrayList<GoodsAllTypeEntity> getSecond(Integer integer);

	@Query("from GoodsAllTypeEntity where secondName like CONCAT('%',?,'%')")
	ArrayList<GoodsAllTypeEntity> search(String name);

}
