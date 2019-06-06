package com.woita.protein_calculator;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProteinCalculator {

    public float calculate(float weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("weight must be a positive number.");
        }
        float protein = weight * 0.8f;
        BigDecimal bd = BigDecimal.valueOf(protein).setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
