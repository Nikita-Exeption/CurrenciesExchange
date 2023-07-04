package org.nikita.CurrenciesExchange;

import org.nikita.CurrenciesExchange.service.CurrencyService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class Config {

    @Bean
    public CurrencyService service() {
        return new CurrencyService();
    }
}
