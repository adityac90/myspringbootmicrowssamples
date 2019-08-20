package com.example.microservices.repository;

import com.example.microservices.models.LicenseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseDetailsRepository extends JpaRepository<LicenseDetails, Long> {

}
