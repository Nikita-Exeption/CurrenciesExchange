package org.nikita.CurrenciesExchange.exception;


public class CurrencyCodeNotExist extends RuntimeException {

    public CurrencyCodeNotExist(String message){
        super(message);
    }
}
