package com.ngoar.currencyExchangePlatform.openExchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OpenExchangeResponse {

    @JsonProperty(value = "data")
    Map<String, CurrencyDetails> data;
}
