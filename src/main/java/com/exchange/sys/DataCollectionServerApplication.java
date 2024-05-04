package com.exchange.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication()
@EnableOpenApi
public class DataCollectionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectionServerApplication.class, args);
	}

}
