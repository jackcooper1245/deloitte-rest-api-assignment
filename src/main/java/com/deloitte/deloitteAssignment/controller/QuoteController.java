package com.deloitte.deloitteAssignment.controller;

import com.deloitte.deloitteAssignment.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.deloitte.deloitteAssignment.model.Quote;


@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteservice;

    @PostMapping("/quote")
    Quote create(@RequestBody Quote quote){
        return quoteservice.save(quote);
    }

    @GetMapping("/quote")
    Iterable<Quote> read(){
        return quoteservice.findAll();
    }

    @PutMapping("/quote")
    Quote update(@RequestBody Quote quote){
        return quoteservice.save(quote);
    }

    @DeleteMapping("/quote/{id}")
    void delete(@PathVariable Integer Id){
        quoteservice.deleteById(Id);
    }
}
