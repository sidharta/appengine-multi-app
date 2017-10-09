package com.ciandt.hello.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.ciandt.hello")
class Application : SpringBootServletInitializer() {

	@Bean
	fun newsApi() = Docket(DocumentationType.SWAGGER_2)
							 .apiInfo(apiInfo())
							 .select()
							 .paths(regex("/hello*"))
							 .build()

	fun apiInfo() = ApiInfoBuilder()
							 .title("Spring REST Sample with Swagger")
							 .description("Spring REST Sample with Swagger")
							 .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
							 .contact("Niklas Heidloff")
							 .license("Apache License Version 2.0")
							 .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
							 .version("2.0")
							 .build()

}

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args)
}
