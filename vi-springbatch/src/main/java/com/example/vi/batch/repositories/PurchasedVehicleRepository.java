package com.example.vi.batch.repositories;

import com.example.vi.batch.model.PurchasedVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedVehicleRepository extends JpaRepository<PurchasedVehicle, Long> {
}
