package com.ngoar.currencyExchangePlatform.openExchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OpenExchangeResponse {

    Map<String, CurrencyDetails> data;
}
