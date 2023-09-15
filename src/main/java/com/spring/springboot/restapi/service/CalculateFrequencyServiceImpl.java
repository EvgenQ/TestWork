package com.spring.springboot.restapi.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculateFrequencyServiceImpl implements CalculateFrequencyService {


    public Map<Character, Integer> calculateFrequency(String inputString) {

        Map<Character, Integer> frequencyMap = separateStringOnCharacter(inputString);

        return frequencyMap
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(value -> -value.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) ->
                { throw new AssertionError();}, LinkedHashMap::new));
    }

    private static Map<Character, Integer> separateStringOnCharacter(String inputString) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        int frequencyCounter = 1;

        for (int i = 0; i < inputString.length(); i++) {
            if (frequencyMap.containsKey(inputString.charAt(i))) {

                frequencyCounter = frequencyMap.get(inputString.charAt(i));
                frequencyCounter++;
                frequencyMap.put(inputString.charAt(i), frequencyCounter);

            } else {
                frequencyMap.put(inputString.charAt(i), frequencyCounter);
            }
            frequencyCounter = 1;
        }
        return frequencyMap;
    }
}
