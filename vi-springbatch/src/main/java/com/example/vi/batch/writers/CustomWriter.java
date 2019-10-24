package com.example.vi.batch.writers;

import com.example.vi.batch.model.PurchasedVehicle;
import com.example.vi.batch.repositories.PurchasedVehicleRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomWriter implements ItemWriter<PurchasedVehicle> {
    @Autowired
    private PurchasedVehicleRepository purchasedVehicleRepository;

    @Override
    public void write(List<? extends PurchasedVehicle> vehicles) throws Exception {
        System.out.println("@@@@@@@@@@ vehicles @@@@@@@  " + vehicles);
        purchasedVehicleRepository.saveAll(vehicles);

    }
}
