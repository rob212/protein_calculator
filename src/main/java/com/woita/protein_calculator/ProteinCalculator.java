package com.woita.protein_calculator;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Protein Calculator 
 * 
 * Service that contains calculator to determine the daily recommended weight of protein in grams that should be consumed 
 * per day based upon the users weight passed in as a float input in kg.
 */
@Service
public class ProteinCalculator {

    public float calculate(float weight) throws IllegalArgumentException {
        if (weight < 0) {
            throw new IllegalArgumentException("weight must be a positive number.");
        }
        float protein = weight * 0.8f;
        BigDecimal bd = new BigDecimal(protein).setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
