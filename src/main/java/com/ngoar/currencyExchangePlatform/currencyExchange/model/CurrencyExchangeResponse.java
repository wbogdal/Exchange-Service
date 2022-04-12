package com.ngoar.currencyExchangePlatform.currencyExchange.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CurrencyExchangeResponse {

    private BigDecimal amount;
    private String currency;
}
