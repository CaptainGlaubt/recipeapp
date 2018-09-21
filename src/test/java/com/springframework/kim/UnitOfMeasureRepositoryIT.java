package com.springframework.kim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springframework.kim.domain.UnitOfMeasure;
import com.springframework.kim.repositories.UnitOfMeasureRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;

	@BeforeEach
	public void setUp() throws Exception {

	}

	@Test
	// @DirtiesContext
	public void findByDescriptionTest() throws Exception {
		Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUnitOfMeasure("Teaspoon");
		assertEquals("Teaspoon", unitOfMeasure.get().getUnitOfMeasure());
	}

	@Test
	public void findByDescriptionCupTest() throws Exception {
		Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUnitOfMeasure("Cup");
		assertEquals("Cup", unitOfMeasure.get().getUnitOfMeasure());
	}
}
