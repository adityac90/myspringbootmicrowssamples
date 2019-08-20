package com.example.microservices.controllers;

import com.example.microservices.httpClient.OrganisationServiceFeignClient;
import com.example.microservices.models.LicenseDetails;
import com.example.microservices.models.Organisation;
import com.example.microservices.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/license")
public class LicenseController {
    @Autowired
    LicenseService licenseService;
    @Value("${app.message:XYZ}")
    private String customeProperty;
    @Autowired
    private Environment environment;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrganisationServiceFeignClient organisationServiceFeignClient;

    @PostMapping(value = "/saveLicense", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LicenseDetails> saveLicenseDetails(@Valid @RequestBody LicenseDetails licenseDetails) {
        System.out.println("######################### CUSTOM PROPERTY ###################################### " + customeProperty);
        LicenseDetails licenseDetailsSaved = licenseService.saveLicenseInfo(licenseDetails);
        if (licenseDetailsSaved != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(licenseDetailsSaved);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LicenseDetails>> getAllLicenseDetails() {
        System.out.println("######################### CUSTOM PROPERTY ###################################### " + environment.getProperty("app.message"));
        List<LicenseDetails> licenseDetails = licenseService.getLicenseDetails();
        if (!licenseDetails.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(licenseDetails);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "/{licenseID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LicenseDetails> getLicenseDetail(@PathVariable String licenseID) {
        long licenseIdValue;
        licenseIdValue = Long.valueOf(licenseID);
        Optional<LicenseDetails> particularLicenseInfo = licenseService.getParticularLicenseInfo(licenseIdValue);
        if (particularLicenseInfo.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(particularLicenseInfo.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    @GetMapping(value = "/orgDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Organisation> getOrganisationDetails() {
        return restTemplate.exchange("http://ORG-SERVICE//api/v1/orgdetail", HttpMethod.GET, null, Organisation.class);

    }

    @GetMapping(value = "/orgDetailsv2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Organisation> getOrganisationDetailsV2() {
        return organisationServiceFeignClient.getOrganisationDetail();

    }


}
