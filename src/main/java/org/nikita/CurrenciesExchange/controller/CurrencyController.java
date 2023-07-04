package org.nikita.CurrenciesExchange.controller;

import org.nikita.CurrenciesExchange.entity.Currency;
import org.nikita.CurrenciesExchange.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Currency> getAllCurrency() {
        return service.getAll();
    }

    @GetMapping("/{code}")
    public Currency getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Currency createCurrency(@RequestBody Currency currency) {
        return service.createCurrency(currency);
    }
}
