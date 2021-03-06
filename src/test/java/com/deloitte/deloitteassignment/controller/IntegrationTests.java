package com.deloitte.deloitteassignment.controller;

import com.deloitte.deloitteassignment.model.Quote;
import javax.xml.bind.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {


    @Autowired
    QuoteController quoteController;

    @Test
    public void testCreateReadDelete() throws ValidationException {
        Quote quote = new Quote("Film", "TestQuote");
        Quote quoteResult = quoteController.create(quote);

        Iterable<Quote> quotes = quoteController.read();
        Assertions.assertThat(quotes).last().hasFieldOrPropertyWithValue("filmName", "Film");

        quoteController.delete(quoteResult.getId());
    }



    @Test(expected = ValidationException.class)
    public void errorHandlingValidExceptionThrow() throws ValidationException {
        quoteController.somthingIsWrong();
    }
}
