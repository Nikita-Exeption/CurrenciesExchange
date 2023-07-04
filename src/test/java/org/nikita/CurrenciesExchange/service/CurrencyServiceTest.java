package org.nikita.CurrenciesExchange.service;

import org.junit.jupiter.api.Test;
import org.nikita.CurrenciesExchange.Config;
import org.nikita.CurrenciesExchange.entity.Currency;
import org.nikita.CurrenciesExchange.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@DataJpaTest
@ContextConfiguration(classes = Config.class)
class CurrencyServiceTest {

    public static final String CODE = "Code";
    public static final String FULL_NAME = "FullName";
    public static final String SIGN = "Sign";
    public static final Currency CURRENCY = new Currency(CODE, FULL_NAME, SIGN);

    @MockBean
    private  CurrencyRepository repository;
    @Autowired
    private CurrencyService service;


    @Test
    void getAllTest() {
        when(repository.findAll()).thenReturn(List.of());
        assertEquals(0, service.getAll().size());

        service.createCurrency(CURRENCY);

        when(repository.findAll()).thenReturn(List.of(CURRENCY));
        assertEquals(1, service.getAll().size());
    }

    @Test
    void getByIdTest() {
        service.createCurrency(CURRENCY);

        String code = CURRENCY.getCode();

        when(repository.findByCode(CODE)).thenReturn(Optional.of(CURRENCY));
        Currency findCurrency = service.getByCode(code);

        assertEquals(findCurrency.getCode(), CURRENCY.getCode());
        assertEquals(findCurrency.getFullName(), CURRENCY.getFullName());
        assertEquals(findCurrency.getSign(), CURRENCY.getSign());
    }

    @Test
    void createCurrencyTest() {
        when(repository.save(CURRENCY)).thenReturn(CURRENCY);
        Currency newCurrency = service.createCurrency(CURRENCY);

        assertEquals(newCurrency.getCode(), CURRENCY.getCode());
        assertEquals(newCurrency.getFullName(), CURRENCY.getFullName());
        assertEquals(newCurrency.getSign(), CURRENCY.getSign());
    }
}