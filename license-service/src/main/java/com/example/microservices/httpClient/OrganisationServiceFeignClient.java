package com.example.microservices.httpClient;

import com.example.microservices.models.Organisation;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ORG-SERVICE", fallbackFactory = HystrixClientFallbackFactory.class)
public interface OrganisationServiceFeignClient {
    @GetMapping("/api/v1/orgdetail")
    ResponseEntity<Organisation> getOrganisationDetail();
}

@Component
class HystrixClientFallbackFactory implements FallbackFactory<OrganisationServiceFeignClient> {

    @Override
    public OrganisationServiceFeignClient create(Throwable throwable) {
        return new OrganisationServiceFeignClient() {
            @Override
            public ResponseEntity<Organisation> getOrganisationDetail() {
                Organisation organisation = new Organisation();
                organisation.setOrdId("dummy-1");
                organisation.setOrgName("dummy-order");
                organisation.setTotalEmployeeStrength(1);
                organisation.setHeadQuaters("KOL");
                return ResponseEntity.status(HttpStatus.OK).body(organisation);
            }
        };
    }
}