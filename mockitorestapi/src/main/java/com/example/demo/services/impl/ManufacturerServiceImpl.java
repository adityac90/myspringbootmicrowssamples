/**
 * 
 */
package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Manufacturer;
import com.example.demo.repositories.ManufacturerRepository;
import com.example.demo.services.ManufacturerService;
import com.example.demo.services.error.manufacturer.ManufactuerNotFoundException;
import com.example.demo.services.error.manufacturer.ManufacturerNotSavedException;

/**
 * @author aditya
 *
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Manufacturer> allManufacturers() throws ManufactuerNotFoundException {
		final List<Manufacturer> findAll = manufacturerRepository.findAll();
		if (findAll.size() == 0) {
			throw new ManufactuerNotFoundException("No Manufacturer details present ");
		}
		return findAll;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Manufacturer manufacturer(int manufacturerId) throws ManufactuerNotFoundException {
		final Optional<Manufacturer> findManufacturerById = manufacturerRepository.findById(manufacturerId);
		if (!findManufacturerById.isPresent()) {
			throw new ManufactuerNotFoundException("Manufacturer - " + manufacturerId + " - record not present in DB");
		}
		return findManufacturerById.get();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Manufacturer saveOrUpdateManufacturer(Manufacturer manufacturer) throws ManufacturerNotSavedException {
		final Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
		if (savedManufacturer == null) {
			throw new ManufacturerNotSavedException("Manufacturer details not saved or updated");
		}
		return savedManufacturer;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void deleteManufacturer(int manufacturerId) {
		final Manufacturer manufacturer = manufacturer(manufacturerId);
		manufacturerRepository.deleteById(manufacturer.getManufacturerID());
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void deleteAllManufacturers() {
		manufacturerRepository.deleteAll();
	}

}
