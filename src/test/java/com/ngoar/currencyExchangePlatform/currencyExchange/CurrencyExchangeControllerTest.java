package com.ngoar.currencyExchangePlatform.currencyExchange;

import com.ngoar.currencyExchangePlatform.currencyExchange.model.CurrencyExchangeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyExchangeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CurrencyExchangeService currencyExchangeService;

    @Test
    public void shouldCalculateCurrency() throws Exception {
        //given
        BigDecimal amount = BigDecimal.TEN;
        String fromCurrency = "EUR";
        String toCurrency = "PLN";

        BigDecimal resultAmount = BigDecimal.valueOf(4.0);

        CurrencyExchangeResponse currencyExchangeResponse = CurrencyExchangeResponse
                .builder()
                .currency("PLN")
                .amount(resultAmount)
                .build();

        //when-then
        given(currencyExchangeService.exchangeCurrency(fromCurrency, amount, toCurrency)).willReturn(currencyExchangeResponse);
        mockMvc.perform(get("/api/v1/exchange/{amount}/{fromCurrency}/{toCurrency}", amount, fromCurrency, toCurrency))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("PLN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value("4.0"));

    }

}