package com.ngoar.currencyExchangePlatform.openExchange;

import com.ngoar.currencyExchangePlatform.openExchange.model.OpenExchangeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenExchangeClientImpl implements OpenExchangeClient {

    private final RestTemplate restTemplate;
    private final OpenExchangeProperties openExchangeProperties;

    @Override
    public OpenExchangeResponse getCurrencyRates(String baseCurrency) {

        return restTemplate.getForObject(
                openExchangeProperties.getOpenExchangeUrl() + "?apikey=" + openExchangeProperties.getOpenExchangeAppId()
                        + "&base_currency=" + baseCurrency,
                OpenExchangeResponse.class);
    }
}
