package com.example.orgservice.controllers;

import com.example.orgservice.pojo.Organisation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisationController {
    @GetMapping("/api/v1/orgdetail")
    public ResponseEntity<Organisation> getOrganisationDetail() {

        Organisation organisation = new Organisation();
        organisation.setOrdId("CT01");
        organisation.setOrgName("CTS");
        organisation.setTotalEmployeeStrength(400000);
        organisation.setHeadQuaters("TeaNeck");
        return ResponseEntity.status(HttpStatus.OK).body(organisation);

    }
}
