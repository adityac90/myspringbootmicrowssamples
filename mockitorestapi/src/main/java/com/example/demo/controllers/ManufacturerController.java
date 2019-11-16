/**
 * 
 */
package com.example.demo.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Manufacturer;
import com.example.demo.services.ManufacturerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author aditya
 *
 */
@RestController
@RequestMapping("/manufacturer")
@Api("Manufacturer controller ")
public class ManufacturerController {
	@Autowired
	private ManufacturerService manufacturerService;

	@GetMapping
	@ApiOperation("Get List of all manufacturers")
	public ResponseEntity<List<Manufacturer>> manufacturers() {
		final List<Manufacturer> allManufacturers = manufacturerService.allManufacturers();
		allManufacturers.stream()
				.forEach(m -> m.add(linkTo(methodOn(ManufacturerController.class).manufacturer(m.getManufacturerID()))
						.withRel("manufacturer")));
		return ResponseEntity.ok(allManufacturers);
	}

	@GetMapping("/{manufacturerId}")
	@ApiOperation("Get a specific Manufacturer")
	public ResponseEntity<Manufacturer> manufacturer(@PathVariable int manufacturerId) {
		final Manufacturer manufacturer = manufacturerService.manufacturer(manufacturerId);
		final Link allMfgRel = linkTo(methodOn(ManufacturerController.class).manufacturers())
				.withRel("all-manufacturer");
		final Link createMfRel = linkTo(methodOn(ManufacturerController.class).saveManufacturerDetail(manufacturer))
				.withRel("save-manufacturer");
		final Link updateMfRel = linkTo(methodOn(ManufacturerController.class).updateManufacturerDetail(manufacturer))
				.withRel("update-manufacturer").withType("PUT");

		List<Link> listOfLinks = new ArrayList<>();
		listOfLinks.add(allMfgRel);
		listOfLinks.add(createMfRel);
		listOfLinks.add(updateMfRel);
		manufacturer.add(listOfLinks);
		return ResponseEntity.ok(manufacturer);
	}

	@PostMapping
	@ApiOperation("Create a Manufacturer")
	public ResponseEntity<Manufacturer> saveManufacturerDetail(@RequestBody Manufacturer manufacturer) {
		final Manufacturer saveOrUpdateManufacturer = manufacturerService.saveOrUpdateManufacturer(manufacturer);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveOrUpdateManufacturer);
	}

	@PutMapping
	@ApiOperation("Update a Manufacturer")
	public ResponseEntity<Manufacturer> updateManufacturerDetail(@RequestBody Manufacturer manufacturer) {
		final Manufacturer saveOrUpdateManufacturer = manufacturerService.saveOrUpdateManufacturer(manufacturer);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(saveOrUpdateManufacturer);
	}

	@DeleteMapping("/{manufacturerId}")
	@ApiOperation("Delete a specific Manufacturer")
	public ResponseEntity<?> deleteAManufacturer(@PathVariable int manufacturerId) {
		manufacturerService.deleteManufacturer(manufacturerId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping
	@ApiOperation("Delete all Manufacturers")
	public ResponseEntity<?> deleteAllManufacturers() {
		manufacturerService.deleteAllManufacturers();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
