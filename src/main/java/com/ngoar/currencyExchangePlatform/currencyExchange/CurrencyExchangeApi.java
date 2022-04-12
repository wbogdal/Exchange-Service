package com.ngoar.currencyExchangePlatform.currencyExchange;

import com.ngoar.currencyExchangePlatform.currencyExchange.model.CurrencyExchangeResponse;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface CurrencyExchangeApi {

    ResponseEntity<CurrencyExchangeResponse> exchangeCurrency(
            String fromCurrency,
            BigDecimal amount,
            String resultCurrency
    );
}
