package com.ngoar.currencyExchangePlatform.openExchange;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("exchange-platform")
@Data
public class OpenExchangeProperties {
    String openExchangeUrl;
    String openExchangeAppId;
}
