package com.ngoar.currencyexchangeplatform.openexchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CurrencyDetails {

    String code;
    BigDecimal value;
}
