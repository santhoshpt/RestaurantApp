package com.restaurant.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{

	@Query("SELECT mi FROM MenuItem mi WHERE mi.name = (:miName)")
	List<MenuItem> findByName(@Param("miName") String miName);

}
