package org.nikita.CurrenciesExchange.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.nikita.CurrenciesExchange.entity.Currency;
import org.nikita.CurrenciesExchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(value = CurrencyController.class)
class CurrencyControllerTest {

    private static final String CODE = "CODE";
    private static final String FULL_NAME = "FULL_NAME";
    private static final String SIGN = "SIGN";
    private static final Currency CURRENCY = new Currency(CODE, FULL_NAME, SIGN);
    @Autowired
    MockMvc mock;
    @MockBean
    CurrencyService service;

    @Test
    void getAllCurrencyTest() {
        when(service.getAll()).thenReturn(List.of());
        try {
            mock.perform(MockMvcRequestBuilders.get("/currencies")).andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk()).
                    andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getByCodeTest() {
        when(service.getByCode(CURRENCY.getCode())).thenReturn(CURRENCY);
        try {
            mock.perform(MockMvcRequestBuilders.get("/currencies/" + CURRENCY.getCode())).andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void createCurrencyTest() {
        when(service.createCurrency(CURRENCY)).thenReturn(CURRENCY);
        try {
            mock.perform(MockMvcRequestBuilders.post("/currencies").contentType(MediaType.APPLICATION_JSON).content(toJSON(CURRENCY)))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toJSON(Currency obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}