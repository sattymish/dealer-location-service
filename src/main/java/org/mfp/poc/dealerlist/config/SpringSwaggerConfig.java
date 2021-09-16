/**
 * 
 */
package org.mfp.poc.dealerlist.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sangeeta
 *
 */


@Configuration
@EnableSwagger2
public class SpringSwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Mazda Field Portal Demo").apiInfo(metaData()).select()
				.paths(regex("/mfp/sales.*")).build();
	}

	private ApiInfo metaData() {

		return new ApiInfoBuilder().title("MFP Service")
				.description("Documentation Generated for Mazda Field Portal API")
				.termsOfServiceUrl("Terms of Version").license("Apache License Version")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").version("1.0").build();
	}


}
