package com.example.microservices.services;

import com.example.microservices.models.LicenseDetails;

import java.util.List;
import java.util.Optional;

public interface LicenseService {

    public LicenseDetails saveLicenseInfo(LicenseDetails licenseDetails);

    public List<LicenseDetails> getLicenseDetails();

    public Optional<LicenseDetails> getParticularLicenseInfo(long licenseId);


}
