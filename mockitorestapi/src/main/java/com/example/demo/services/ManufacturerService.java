/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Manufacturer;
import com.example.demo.services.error.manufacturer.ManufactuerNotFoundException;
import com.example.demo.services.error.manufacturer.ManufacturerNotSavedException;


/**
 * @author aditya
 *
 */

public interface ManufacturerService {

	/* List all manufacturer details */
	List<Manufacturer> allManufacturers() throws ManufactuerNotFoundException;

	/* Get a particular manufacturer detail */
	Manufacturer manufacturer(int manufacturerId) throws ManufactuerNotFoundException;

	/* Save or update manufacturer details to database */
	Manufacturer saveOrUpdateManufacturer(Manufacturer manufacturer) throws ManufacturerNotSavedException;

	/* Delete a manufacturer */
	void deleteManufacturer(int manufacturerId);

	/* Delete all manufacturer */
	void deleteAllManufacturers();
}
