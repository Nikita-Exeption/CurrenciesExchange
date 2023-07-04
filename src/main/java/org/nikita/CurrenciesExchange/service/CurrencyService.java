package org.nikita.CurrenciesExchange.service;

import org.nikita.CurrenciesExchange.entity.Currency;
import org.nikita.CurrenciesExchange.exception.CurrencyCodeNotExist;
import org.nikita.CurrenciesExchange.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;


    public List<Currency> getAll() {
        return repository.findAll();
    }

    public Currency getByCode(String code) {
        return repository.findByCode(code).orElseThrow(() -> new CurrencyCodeNotExist("Did not find currency by code: " + code));
    }

    public Currency createCurrency(Currency currency) {
        return repository.save(currency);
    }
}
