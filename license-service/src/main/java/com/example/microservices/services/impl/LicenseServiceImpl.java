package com.example.microservices.services.impl;

import com.example.microservices.models.LicenseDetails;
import com.example.microservices.repository.LicenseDetailsRepository;
import com.example.microservices.services.LicenseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LicenseServiceImpl implements LicenseService {
    @Autowired
    private LicenseDetailsRepository licenseDetailsRepository;

    @Override
    public LicenseDetails saveLicenseInfo(LicenseDetails licenseDetails) {
        return licenseDetailsRepository.save(licenseDetails);
    }

    @Override
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")}
            , fallbackMethod = "getDummyLicenseDetails"
            , threadPoolKey = "licenseDetailsPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }


    )
    public List<LicenseDetails> getLicenseDetails() {
        //uncomment this Thread.sleep to see circuit breaker behavior of hystrix
        //If any call by default takes more than 1000ms it will trip the circuit
        //you can also override this using execution.isolation.thread.timeoutInMilliSeconds property
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return licenseDetailsRepository.findAll();
    }

    //fallback method incase Hystrix Trips the method
    public List<LicenseDetails> getDummyLicenseDetails() {
        List<LicenseDetails> l = new ArrayList<>();
        LicenseDetails ld = new LicenseDetails();
        ld.setLicense_id(420);
        ld.setLicense_vendor("oracle");
        ld.setSoftwareName("dummy");
        ld.setLicense_expiration_date(new Date());
        l.add(ld);
        return l;
    }

    @Override
    public Optional<LicenseDetails> getParticularLicenseInfo(long licenseId) {
        return licenseDetailsRepository.findById(licenseId);
    }


}
