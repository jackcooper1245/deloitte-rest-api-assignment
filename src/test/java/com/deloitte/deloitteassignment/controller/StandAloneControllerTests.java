package com.deloitte.deloitteassignment.controller;

import com.deloitte.deloitteassignment.model.Quote;
import com.deloitte.deloitteassignment.service.QuoteService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class StandAloneControllerTests {

    @MockBean
    QuoteService quoteService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception {
        Quote quote = new Quote("Film", "FilmQuote");
        List<Quote> quotes = Arrays.asList(quote);

        Mockito.when(quoteService.findAll()).thenReturn(quotes);

        mockMvc.perform(get("/quotes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].film-name", Matchers.is("Film")));
    }

}

