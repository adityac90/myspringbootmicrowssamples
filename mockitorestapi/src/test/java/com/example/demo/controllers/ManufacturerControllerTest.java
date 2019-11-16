/**
 * 
 */
package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.entities.Manufacturer;
import com.example.demo.services.ManufacturerService;
import com.example.demo.services.error.manufacturer.ManufactuerNotFoundException;
import com.example.demo.services.error.manufacturer.ManufacturerNotSavedException;

import org.junit.Assert;
import org.junit.Ignore;

/**
 * @author aditya
 *
 */
@SpringBootTest
@Ignore
class ManufacturerControllerTest {
	@InjectMocks
	private ManufacturerController mnc;
	@Mock
	private ManufacturerService mfs;

	/**
	 * Test method for
	 * {@link com.example.demo.controllers.ManufacturerController#manufacturers()}.
	 */
	@Test
	void testManufacturers() {
		List<Manufacturer> l = new ArrayList<>();
		l.add(new Manufacturer(1, "dummycode1", "dummyname1", "dummydesc1"));
		l.add(new Manufacturer(2, "dummycode2", "dummyname2", "dummydesc2"));
		l.add(new Manufacturer(3, "dummycode3", "dummyname3", "dummydesc3"));
		when(mfs.allManufacturers()).thenReturn(l);
		final ResponseEntity<List<Manufacturer>> manufacturersEntity = mnc.manufacturers();
		Assert.assertEquals(200, manufacturersEntity.getStatusCodeValue());
		Assert.assertEquals(3, manufacturersEntity.getBody().size());
	}

	@Test
	void testManufacturers_Exception() {
		List<Manufacturer> l = new ArrayList<>();

		when(mfs.allManufacturers()).thenThrow(ManufactuerNotFoundException.class);
		Assertions.assertThrows(ManufactuerNotFoundException.class, () -> {
			mnc.manufacturers();
		});
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controllers.ManufacturerController#manufacturer(int)}.
	 */
	@Test
	void testManufacturer() {
		when(mfs.manufacturer(1)).thenReturn(new Manufacturer(1, "dummy code- 1 ", "dummy name - 1", "dummy desc - 1"));
		final ResponseEntity<Manufacturer> manufacturerEntity = mnc.manufacturer(1);
		Assert.assertEquals(200, manufacturerEntity.getStatusCodeValue());
		Assert.assertEquals("dummy code- 1 ", manufacturerEntity.getBody().getManufacturerCode());
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controllers.ManufacturerController#saveManufacturerDetail(com.example.demo.entities.Manufacturer)}.
	 */
	@Test
	void testSaveManufacturerDetail() {
		Manufacturer m = new Manufacturer();
		m.setManufacturerName("test name");
		m.setManufacturerCode("test code");
		m.setManufacturerDesc("test desc");
		when(mfs.saveOrUpdateManufacturer(m)).thenReturn(m);
		final ResponseEntity<Manufacturer> saveManufacturerDetailEntity = mnc.saveManufacturerDetail(m);
		Assert.assertEquals(201, saveManufacturerDetailEntity.getStatusCodeValue());
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controllers.ManufacturerController#updateManufacturerDetail(com.example.demo.entities.Manufacturer)}.
	 */
	@Test
	void testUpdateManufacturerDetail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controllers.ManufacturerController#deleteAManufacturer(int)}.
	 */
	@Test
	void testDeleteAManufacturer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controllers.ManufacturerController#deleteAllManufacturers()}.
	 */
	@Test
	void testDeleteAllManufacturers() {
		fail("Not yet implemented");
	}

}
