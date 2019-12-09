package com.ehi.vehicles.vi.config.docs;
/**
 * Open API Swagger 3 Rest API Spring doucumentation
 * This configutation class customizes the title and description of the doc.
 */

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiSpringDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Vehilce Incentives Rest API").description(
                        "This is a REST API which is consumed by new Vehicle Incentive UI."));
    }

}
