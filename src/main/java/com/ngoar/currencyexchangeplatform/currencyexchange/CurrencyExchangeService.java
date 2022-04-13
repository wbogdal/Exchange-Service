package com.ngoar.currencyexchangeplatform.currencyexchange;

import com.ngoar.currencyexchangeplatform.currencyexchange.model.CurrencyExchangeResponse;
import com.ngoar.currencyexchangeplatform.openexchange.OpenExchangeClient;
import com.ngoar.currencyexchangeplatform.openexchange.model.OpenExchangeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;

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
        if (!isValidCurrencyCode(fromCurrency) || !isValidCurrencyCode(resultCurrency)) {
            throw new CurrencyValidationException("It is not proper currency code");
        }

        OpenExchangeResponse openExchangeResponse = openExchangeClient.getCurrencyRates(fromCurrency);

        return CurrencyExchangeResponse.builder()
                .amount(countExchangedCurrency(amount, openExchangeResponse.getData().get(resultCurrency).getValue()))
                .currency(resultCurrency)
                .build();
    }

    private BigDecimal countExchangedCurrency(BigDecimal amount, BigDecimal rate) {
        return amount.multiply(rate);
    }

    private boolean isValidCurrencyCode(String currencyCode) {
        return Currency.getAvailableCurrencies().stream().anyMatch(currency -> currency.getCurrencyCode().equals(currencyCode));
    }
}
