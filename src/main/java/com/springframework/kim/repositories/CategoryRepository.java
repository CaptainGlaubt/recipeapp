package com.springframework.kim.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.springframework.kim.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findByDescription(String description);
}
