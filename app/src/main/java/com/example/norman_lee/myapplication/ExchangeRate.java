package com.example.norman_lee.myapplication;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ExchangeRate {

    private BigDecimal exchangeRate;
    private static String defaultRate = "2.95000";
    private static final int DEFAULT_PRECISION = 5;
    private int precision = DEFAULT_PRECISION;
    private MathContext mathContext;


    ExchangeRate(){
        exchangeRate = new BigDecimal(defaultRate);
        instantiateMathContext(DEFAULT_PRECISION);
    }

    ExchangeRate(String exchangeRate){
        this.exchangeRate = new BigDecimal(exchangeRate);
        instantiateMathContext(DEFAULT_PRECISION);
    }

    ExchangeRate(String home, String foreign) {

        // home value = foreign value * ( home value / foreign value )
        // exchange rate = (home value / foreign value )
        instantiateMathContext(DEFAULT_PRECISION);
        //TODO 3.13a The constructor initializes exchangeRate by calculating the exchangeRate
        BigDecimal homeValue = new BigDecimal(home);
        BigDecimal foreignValue = new BigDecimal(foreign);
        exchangeRate = homeValue.divide(foreignValue,mathContext);

        //exchangeRate = new BigDecimal(defaultRate); //delete
    }

    BigDecimal getExchangeRate(){
        return exchangeRate;
    }

    BigDecimal calculateAmount(String foreign){
        //TODO 2.5a complete this method to return the amount
        BigDecimal foreignValue = new BigDecimal(foreign);
        BigDecimal result = foreignValue.multiply(exchangeRate);
        return result;
    }

    void setPrecision(int precision){
        this.precision = precision;
        instantiateMathContext(precision);
    }

    private void instantiateMathContext(int precision){
        mathContext = new MathContext(precision, RoundingMode.HALF_UP);
    }
}
