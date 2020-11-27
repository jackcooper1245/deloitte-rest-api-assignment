package com.deloitte.deloitteAssignment.controller;

import com.deloitte.deloitteAssignment.service.QuoteService;
import com.deloitte.deloitteAssignment.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.deloitte.deloitteAssignment.model.Quote;
import com.deloitte.deloitteAssignment.model.Actor;
import javax.persistence.Embedded;
import javax.xml.bind.ValidationException;
import java.util.Optional;


@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteservice;

    @PostMapping("/quote")
    Quote create(@RequestBody Quote quote) throws ValidationException {
        if (quote.getId() == 0 && quote.getFilmName()!= null && quote.getContent() != null)
        return quoteservice.save(quote);
        else throw new ValidationException("quotes must have content and a film name");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException e) {
        return new ErrorMessage("400", e.getMessage());
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
    ResponseEntity<Quote> update(@RequestBody Quote quote){
        if ( quoteservice.findById(quote.getId()).isPresent())
            return new ResponseEntity(quoteservice.save(quote), HttpStatus.OK);
        else
            return new ResponseEntity(quote, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/quote/{id}")
    void delete(@PathVariable Integer id){
        quoteservice.deleteById(id);
    }


}
