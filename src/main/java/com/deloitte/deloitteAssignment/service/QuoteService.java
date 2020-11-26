package com.deloitte.deloitteAssignment.service;

import org.springframework.data.repository.CrudRepository;
import com.deloitte.deloitteAssignment.model.Quote;

public interface  QuoteService extends CrudRepository<Quote, Integer> {

}
