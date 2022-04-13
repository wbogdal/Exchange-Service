package com.ngoar.currencyexchangeplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyExchangePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangePlatformApplication.class, args);
	}

}
