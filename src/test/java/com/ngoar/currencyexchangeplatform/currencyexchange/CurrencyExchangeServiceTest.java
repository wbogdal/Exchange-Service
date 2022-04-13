package com.ngoar.currencyexchangeplatform.currencyexchange;

import com.ngoar.currencyexchangeplatform.currencyexchange.model.CurrencyExchangeResponse;
import com.ngoar.currencyexchangeplatform.openexchange.OpenExchangeClient;
import com.ngoar.currencyexchangeplatform.openexchange.model.CurrencyDetails;
import com.ngoar.currencyexchangeplatform.openexchange.model.OpenExchangeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class CurrencyExchangeServiceTest {

    private CurrencyExchangeService currencyExchangeService;

    @MockBean
    OpenExchangeClient openExchangeClient;

    @BeforeEach
    public void before() {
        currencyExchangeService = new CurrencyExchangeService(openExchangeClient);
    }

    @Test
    public void shouldExchangeCurrency() {
        //given
        String baseCurrency = "PLN";
        BigDecimal amount = BigDecimal.ONE;
        String toCurrency = "USD";

        CurrencyDetails currencyDetails = new CurrencyDetails("EUR", BigDecimal.valueOf(12.5));
        CurrencyDetails currencyDetails2 = new CurrencyDetails("USD", BigDecimal.valueOf(10.0));

        OpenExchangeResponse openExchangeResponse = new OpenExchangeResponse(Map.of("EUR", currencyDetails, "USD", currencyDetails2));

        given(openExchangeClient.getCurrencyRates(anyString())).willReturn(openExchangeResponse);

        //when
        CurrencyExchangeResponse result = currencyExchangeService.exchangeCurrency(baseCurrency, amount, toCurrency);

        //then
        verify(openExchangeClient, times(1)).getCurrencyRates(anyString());
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(10.0));
    }

}