package com.ngoar.currencyexchangeplatform.openexchange;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("exchange-platform")
@Data
public class OpenExchangeProperties {
    private String openExchangeUrl;
    private String openExchangeAppId;
}
