package br.com.professional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket apiDetails() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select().apis(RequestHandlerSelectors.basePackage("br.com.professional")).paths(PathSelectors.any())
				.build().apiInfo(this.apiInformation().build());

		return docket;
	}

	private ApiInfoBuilder apiInformation() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("RestAPI - Example");
		apiInfoBuilder.description("An reference API to use in other projects");
		apiInfoBuilder.version("1.0.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("http://customurl-here.com");
		apiInfoBuilder.contact(this.contact());

		return apiInfoBuilder;
	}

	private Contact contact() {
		return new Contact("Lucas Feitozas", "github url", "lucasfeitozas@gmail.com");
	}
}
