package com.example.vi.batch.processor;

import com.example.vi.batch.model.PurchasedVehicle;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomVinProcessor implements ItemProcessor<PurchasedVehicle, PurchasedVehicle> {
    @Override
    public PurchasedVehicle process(PurchasedVehicle purchasedVehicle) throws Exception {
        if (!purchasedVehicle.getTypeofbuy().equalsIgnoreCase("RISK") && !purchasedVehicle.getTypeofbuy().equalsIgnoreCase("BUYBACK")) {
            System.out.println("@@@@@@@  TYPE OF BUY IS WRONG @@@ , SO REJECTING THIS");
            return null;
        }
        return purchasedVehicle;
    }
}
