package com.woita.protein_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProteinCalculatorController {

    @Autowired
    private ProteinCalculator proteinCalculator;

    @RequestMapping("/calc")
    String calc(@RequestParam("weight") float weight) {
        try {
            return String.valueOf(proteinCalculator.calculate(weight));
        } catch(IllegalArgumentException e) {
            return "Error : "  + e.getMessage();
        }
    } 
}
