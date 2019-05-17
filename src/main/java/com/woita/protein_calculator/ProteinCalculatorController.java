package com.woita.protein_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProteinCalculatorController {

    @Autowired
    private ProteinCalculator proteinCalculator;

    @RequestMapping("/calc")
    ResponseEntity<String> calc(@RequestParam("weight") float weight) {
        try {
            String proteinResponse = String.valueOf(proteinCalculator.calculate(weight));
            return ResponseEntity.ok(proteinResponse);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    } 
}
