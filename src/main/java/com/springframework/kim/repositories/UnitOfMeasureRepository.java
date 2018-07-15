package com.springframework.kim.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springframework.kim.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	Optional<UnitOfMeasure> findByUnitOfMeasure(String uom);
}
