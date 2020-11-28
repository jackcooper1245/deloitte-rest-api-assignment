package com.deloitte.deloitteassignment;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.deloitte.deloitteassignment.model.Quote;
import org.assertj.core.api.Assertions;



public class SystemTests {

    @Test
    public void testCreateReadAndDelete(){
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/quotes";

        Quote quote = new Quote("Dave", "FilmQuote");
        ResponseEntity<Quote> entity = restTemplate.postForEntity(url, quote, Quote.class);

        Quote[] quotes = restTemplate.getForObject(url, Quote[].class);
        Assertions.assertThat(quotes).extracting(Quote::getFilmName).contains("Dave");

        restTemplate.delete(url + "/" + entity.getBody().getId());

    }
}
