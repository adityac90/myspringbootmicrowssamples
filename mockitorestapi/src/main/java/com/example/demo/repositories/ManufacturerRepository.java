/**
 * 
 */
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Manufacturer;

/**
 * @author aditya
 *
 */
@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
