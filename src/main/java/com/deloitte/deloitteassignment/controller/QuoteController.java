package com.deloitte.deloitteassignment.controller;

import com.deloitte.deloitteassignment.service.QuoteService;
import com.deloitte.deloitteassignment.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.deloitte.deloitteassignment.model.Quote;

import javax.xml.bind.ValidationException;
import java.util.Optional;


@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteservice;

    @PostMapping("/quotes")
    public Quote create(@RequestBody Quote quote) throws ValidationException {
        if (quote.getId() == 0 && quote.getFilmName()!= null && quote.getContent() != null)
        return quoteservice.save(quote);
        else throw new ValidationException("quotes must have content and a filmName");
    }



    @GetMapping("/quotes")
    public Iterable<Quote> read(){
        return quoteservice.findAll();
    }

    @GetMapping("/quotes/{id}")
    Optional<Quote> findById(@PathVariable Integer id) {
        return quoteservice.findById(id);
    }

    @GetMapping("/quotes/search")
    Iterable<Quote> findByQuery(
            @RequestParam("filmName") String filmName){
        return quoteservice.findByFilmName(filmName);
    }

    @PutMapping("/quotes")
    ResponseEntity<Quote> update(@RequestBody Quote quote){
        if ( quoteservice.findById(quote.getId()).isPresent())
            return new ResponseEntity(quoteservice.save(quote), HttpStatus.OK);
        else
            return new ResponseEntity(quote, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/quotes/{id}")
    public void delete(@PathVariable Integer id){
        quoteservice.deleteById(id);
    }

    @GetMapping("/wrong")
    Quote somthingIsWrong() throws ValidationException {
        throw new ValidationException("something is wrong");
    }


}
