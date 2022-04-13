package com.ngoar.currencyexchangeplatform.openexchange;

import com.ngoar.currencyexchangeplatform.openexchange.model.OpenExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "open-exchange", url = "${exchange-platform.openExchangeUrl}")
public interface OpenExchangeClient {

    @RequestMapping(method = RequestMethod.GET, value = "?apikey=${exchange-platform.openExchangeAppId}&base_currency={baseCurrency}"
            , produces = "application/json")
    OpenExchangeResponse getCurrencyRates(@PathVariable("baseCurrency") String baseCurrency);
}
