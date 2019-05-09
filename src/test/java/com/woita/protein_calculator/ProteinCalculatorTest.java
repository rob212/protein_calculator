package com.woita.protein_calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProteinCalculatorTest {
    private ProteinCalculator proteinCalc = new ProteinCalculator();

    @Test
    public void given0_calculateProteinReturn0() {
        assertEquals(0.0f, proteinCalc.calculate(0.0f), 0.0002);
    }

    @Test
    public void givenValidWeight_calculatProteinReturnsValidProtein() {
        assertEquals(54.4, proteinCalc.calculate(68.0f), 0.0002);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeInput_proteinCalculatorThrowsException() {
        proteinCalc.calculate(-68.0f);
    }
}