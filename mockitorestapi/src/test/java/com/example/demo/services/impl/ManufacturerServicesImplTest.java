/**
 * 
 */
package com.example.demo.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Manufacturer;
import com.example.demo.repositories.ManufacturerRepository;
import com.example.demo.services.error.manufacturer.ManufacturerNotSavedException;

import org.junit.Assert;

/**
 * @author aditya
 *
 */
@SpringBootTest

class ManufacturerServicesImplTest {
	@InjectMocks
	private ManufacturerServiceImpl mfs;
	@Mock
	private ManufacturerRepository mfr;

	/*
	 * @Autowired private ManufacturerRepository mfr;
	 */

	/**
	 * Test method for
	 * {@link com.example.demo.services.impl.ManufacturerServiceImpl#allManufacturers()}.
	 */
	@Test
	void testAllManufacturers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.example.demo.services.impl.ManufacturerServiceImpl#manufacturer(int)}.
	 */
	@Test
	void testManufacturer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.example.demo.services.impl.ManufacturerServiceImpl#saveOrUpdateManufacturer(com.example.demo.entities.Manufacturer)}.
	 */
	@Test
	void testSaveOrUpdateManufacturer() {
		Manufacturer m = new Manufacturer();
		m.setManufacturerCode("test code");
		m.setManufacturerName("test Name");
		m.setManufacturerDesc("test description");
		when(mfr.save(m)).thenReturn(m);
		final Manufacturer save = mfs.saveOrUpdateManufacturer(m);
		Assert.assertEquals("test code", save.getManufacturerCode());
	}

	@Test
	void testSaveOrUpdateManufacturerFailure() {
		Manufacturer m = new Manufacturer();
		m.setManufacturerCode("test code");
		m.setManufacturerName("test Name");
		m.setManufacturerDesc("test description");
		when(mfr.save(m)).thenReturn(null);
		Assertions.assertThrows(ManufacturerNotSavedException.class, () -> {
			mfs.saveOrUpdateManufacturer(m);
		});
	}

	/**
	 * Test method for
	 * {@link com.example.demo.services.impl.ManufacturerServiceImpl#deleteManufacturer(int)}.
	 */
	@Test
	void testDeleteManufacturer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.example.demo.services.impl.ManufacturerServiceImpl#deleteAllManufacturers()}.
	 */
	@Test
	void testDeleteAllManufacturers() {
		fail("Not yet implemented");
	}

}
