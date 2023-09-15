package com.spring.springboot.restapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(MockitoExtension.class)
class CalculateFrequencyServiceImplTest {

    @Test
    void calculateFrequency_ShouldReturnedNotEmptyMap() {

        CalculateFrequencyService service = new CalculateFrequencyServiceImpl();

        var inputString = "aaabbbccc";

        assertNotNull(inputString);
        assertEquals(3, service.calculateFrequency(inputString).size());
        assertEquals("{a=3, b=3, c=3}", service.calculateFrequency(inputString).toString());

    }
}