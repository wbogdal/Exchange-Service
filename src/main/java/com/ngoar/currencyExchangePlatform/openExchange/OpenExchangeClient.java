package com.ngoar.currencyExchangePlatform.openExchange;

import com.ngoar.currencyExchangePlatform.openExchange.model.OpenExchangeResponse;

public interface OpenExchangeClient {

    OpenExchangeResponse getCurrencyRates(String baseCurrency);
}
