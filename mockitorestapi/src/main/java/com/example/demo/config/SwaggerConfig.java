/**
 * 
 */
package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.JsonPathLinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.hal.HalLinkDiscoverer;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.plugin.core.support.PluginRegistryFactoryBean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author aditya
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	// This is needed to make Swagger work with HateOAS
	@Bean
	public LinkDiscoverers discoverers() {
		List<JsonPathLinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new HalLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}

	// This is needed to make Swagger work with HateOAS
	@Bean
	public LinkRelationProvider provider() {
		return new EvoInflectorLinkRelationProvider();
	}

	// This is needed to make Swagger work with HateOAS
	@Bean
	@Primary
	public PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext> myPluginRegistryProvider() {

		PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext> factory = new PluginRegistryFactoryBean<>();

		factory.setType(LinkRelationProvider.class);
		Class<?> classes[] = new Class<?>[1];
		classes[0] = DelegatingLinkRelationProvider.class;
		factory.setExclusions(classes);

		return factory;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API").description("Employee Management REST API")
				.contact(new Contact("Ramesh Fadatare", "www.javaguides.net", "ramesh24fadatare@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}
}
