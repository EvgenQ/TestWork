package com.spring.springboot.restapi.service;

import java.util.Map;

public interface CalculateFrequencyService {
    Map<Character, Integer> calculateFrequency(String inputString);
}
