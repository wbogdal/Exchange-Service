package com.ngoar.currencyexchangeplatform.currencyexchange;

import com.ngoar.currencyexchangeplatform.currencyexchange.model.CurrencyExchangeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RequestMapping("api/v1")
@RestController
@Slf4j
@Validated
public class CurrencyExchangeController implements CurrencyExchangeApi {

    private final CurrencyExchangeService currencyExchangeService;

    @Override
    @GetMapping(value = "/exchange/{amount}/{fromCurrency}/{toCurrency}")
    public ResponseEntity<CurrencyExchangeResponse> exchangeCurrency(
            @PathVariable("fromCurrency") String fromCurrency,
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("toCurrency") String resultCurrency
    ) {

        log.info("Received request to exchange {} {} into {}", amount, fromCurrency, resultCurrency);
        CurrencyExchangeResponse currencyExchangeResponse =
                currencyExchangeService.exchangeCurrency(fromCurrency, amount, resultCurrency);
        return new ResponseEntity<>(currencyExchangeResponse, HttpStatus.OK);
    }
}
