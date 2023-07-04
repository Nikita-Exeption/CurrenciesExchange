package org.nikita.CurrenciesExchange.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    private static final String CODE = "Code";
    private static final String FULL_NAME = "FullName";
    private static final String SIGH = "Sigh";

    private static Currency CURRENCY;

    @BeforeEach
    void initInstance(){
        CURRENCY = new Currency(CODE, FULL_NAME, SIGH);
    }

    @Test
    void getCodeTest() {
        assertEquals(CURRENCY.getCode(), CODE);
    }

    @Test
    void setCodeTest() {
        String expect = "NewCode";

        CURRENCY.setCode(expect);

        assertEquals(CURRENCY.getCode(), expect);
    }

    @Test
    void getFullNameTest() {
        assertEquals(CURRENCY.getFullName(), FULL_NAME);
    }

    @Test
    void setFullNameTest() {
        String expect = "newName";

        CURRENCY.setFullName(expect);

        assertEquals(CURRENCY.getFullName(), expect);
    }

    @Test
    void getSignTest() {
        assertEquals(CURRENCY.getSign(), SIGH);
    }

    @Test
    void setSignTest() {
        String expect = "newSigh";

        CURRENCY.setSign(expect);

        assertEquals(CURRENCY.getSign(), expect);
    }
}