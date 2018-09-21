package com.springframework.kim.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springframework.kim.domain.UnitOfMeasure;
import com.springframework.kim.repositories.UnitOfMeasureRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
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
