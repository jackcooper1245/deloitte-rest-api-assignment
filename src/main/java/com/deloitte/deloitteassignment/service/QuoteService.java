package com.deloitte.deloitteassignment.service;

import org.springframework.data.repository.CrudRepository;
import com.deloitte.deloitteassignment.model.Quote;

public interface  QuoteService extends CrudRepository<Quote, Integer> {
Iterable<Quote> findByFilmName(String filmName);

}
