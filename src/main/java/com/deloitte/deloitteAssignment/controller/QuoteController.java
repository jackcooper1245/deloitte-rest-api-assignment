package com.deloitte.deloitteAssignment.controller;

import com.deloitte.deloitteAssignment.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.deloitte.deloitteAssignment.model.Quote;

import java.util.Optional;


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

    @GetMapping("/quote/{id}")
    Optional<Quote> findById(@PathVariable Integer id) {
        return quoteservice.findById(id);
    }

    @GetMapping("/quote/search")
    Iterable<Quote> findByQuery(
            @RequestParam("filmName") String filmName){
        return quoteservice.findByFilmName(filmName);
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
