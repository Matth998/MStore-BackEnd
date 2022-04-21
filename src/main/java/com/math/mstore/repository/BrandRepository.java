package com.math.mstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.math.mstore.model.BrandModel;

public interface BrandRepository extends JpaRepository<BrandModel, Long>{

	public List<BrandModel> findAllByDescriptionContainingIgnoreCase(String description);
	
}
