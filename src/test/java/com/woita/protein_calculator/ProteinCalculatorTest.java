package com.woita.protein_calculator;

import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ProteinCalculatorTest {
    private ProteinCalculator proteinCalc = new ProteinCalculator();

    @Test
    @Parameters({ 
        "0.0f, 0.0f", 
        "68.0f, 54.4f", 
        "62.375f, 49.9f", 
        "62.5f, 50.0f", })
    public void givenValidInputs_calculateReturnsExpectedResult(float weight, float expected_result) {
        assertEquals(expected_result, proteinCalc.calculate(weight), 0.0002);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeInput_calculateThrowsException() {
        proteinCalc.calculate(-68.0f);
    }
}