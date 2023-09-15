package com.spring.springboot.restapi.controllers;

import com.spring.springboot.restapi.exeptions_handling.EmptyOrNullRequestException;
import com.spring.springboot.restapi.exeptions_handling.LengthStringRequestException;
import com.spring.springboot.restapi.service.CalculateFrequencyService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class FrequencyRepeatCharacterInStringController {

    private final static String GET_CALCULATE_FREQUNCY = "calculate-frequency";

    private final CalculateFrequencyService service;

    public FrequencyRepeatCharacterInStringController(CalculateFrequencyService service) {
        this.service = service;
    }

    @GetMapping(GET_CALCULATE_FREQUNCY)
    public ResponseEntity<Map<Character, Integer>> calculateFrequency(@RequestParam String request) {

        if (request == null || request.isEmpty()) {
            throw new EmptyOrNullRequestException("Входящая строка была пустой или null.");
        }
        if (request.length() >= 101) {
            throw new LengthStringRequestException("Строка содержит более 100 символов.");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.calculateFrequency(request));
    }
}
