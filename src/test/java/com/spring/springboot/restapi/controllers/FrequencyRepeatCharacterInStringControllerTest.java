package com.spring.springboot.restapi.controllers;

import com.spring.springboot.restapi.exeptions_handling.EmptyOrNullRequestException;
import com.spring.springboot.restapi.exeptions_handling.LengthStringRequestException;
import com.spring.springboot.restapi.service.CalculateFrequencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FrequencyRepeatCharacterInStringControllerTest {

    @Mock
    CalculateFrequencyService service;

    @InjectMocks
    FrequencyRepeatCharacterInStringController controller;

    @Test
    void calculateFrequency_ShouldReturnValidResponseEntity() {

        //given
        var response = new LinkedHashMap<>();
        doReturn(response).when(this.service).calculateFrequency("aaabbbccc");

        //when
        var responseEntity = this.controller.calculateFrequency("aaabbbccc");

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(response, responseEntity.getBody());

    }

    @Test
    void calculateFrequency_ShouldReturnEmptyOrNullRequestException() {

        assertThrows(EmptyOrNullRequestException.class, () -> controller.calculateFrequency(""));

    }

    @Test
    void calculateFrequency_ShouldReturnLengthStringRequestException() {

        assertThrows(LengthStringRequestException.class,
                () -> controller.calculateFrequency("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" +
                        "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" +
                        "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" +
                        "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"));

    }


}