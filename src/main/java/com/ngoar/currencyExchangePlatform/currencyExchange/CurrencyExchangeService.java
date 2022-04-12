package com.ngoar.currencyExchangePlatform.currencyExchange;

import com.ngoar.currencyExchangePlatform.currencyExchange.model.CurrencyExchangeResponse;
import com.ngoar.currencyExchangePlatform.openExchange.OpenExchangeClient;
import com.ngoar.currencyExchangePlatform.openExchange.model.OpenExchangeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
@Slf4j
public class CurrencyExchangeService {

    private final OpenExchangeClient openExchangeClient;

    public CurrencyExchangeResponse exchangeCurrency(
            String fromCurrency,
            BigDecimal amount,
            String resultCurrency
    ) {
        OpenExchangeResponse openExchangeResponse = openExchangeClient.getCurrencyRates(fromCurrency);

        return CurrencyExchangeResponse.builder()
                .amount(countExchangedCurrency(amount, openExchangeResponse.getData().get(resultCurrency).getValue()))
                .currency(resultCurrency)
                .build();
    }

    private BigDecimal countExchangedCurrency(BigDecimal amount, BigDecimal rate) {
        return amount.multiply(rate);
    }
}
