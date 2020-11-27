package com.deloitte.deloitteAssignment.controller;

import javax.xml.bind.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.xml.bind.ValidationException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {


    @Autowired
    QuoteController quoteController;

    @Test(expected = ValidationException.class)
    public void errorHandlingValidExceptionThrow() throws ValidationException {
        quoteController.somthingIsWrong();
    }
}
