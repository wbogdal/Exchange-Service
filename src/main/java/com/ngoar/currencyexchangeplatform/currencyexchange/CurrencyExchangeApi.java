package com.ngoar.currencyexchangeplatform.currencyexchange;

import com.ngoar.currencyexchangeplatform.currencyexchange.model.CurrencyExchangeResponse;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public interface CurrencyExchangeApi {

    ResponseEntity<CurrencyExchangeResponse> exchangeCurrency(
            @NotBlank @Pattern(regexp = "[a-zA-Z]{3}") String fromCurrency,
            @NotNull BigDecimal amount,
            @NotBlank @Pattern(regexp = "[a-zA-Z]{3}") String resultCurrency
    );
}
