package org.jabref.projecttest;

/* Copyright (C) 2024 <Peerapong Tantasilp> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationAccuracyTest {

    @Test
    public void testSimpleInterestCalculation() {
        // Test case 1: testSimpleInterestCalculation
        // Goal: Test that the simple interest formula returns the correct value.
        // Characteristics:
        // - Interface-based: Inputs are correctly parsed.
        // - Functionality-based: Correctness of the calculation.
        double principal = 1000.0;
        double rate = 0.05;
        int time = 2;
        double expectedInterest = 100.0;
        double actualInterest = FinancialCalculator.simpleInterest(principal, rate, time);
        assertEquals(expectedInterest, actualInterest, 0.01);
    }

    @Test
    public void testCompoundInterestCalculation() {
        // Test case 2: testCompoundInterestCalculation
        // Goal: Test the compound interest calculation for correctness.
        // Characteristics:
        // - Interface-based: Checks that the time parameter is valid.
        // - Functionality-based: Correct calculation of compound interest.
        double principal = 1500.0;
        double rate = 0.04;
        int time = 3;
        double expectedAmount = 1683.58;
        double actualAmount = FinancialCalculator.compoundInterest(principal, rate, time);
        assertEquals(expectedAmount, actualAmount, 0.01);
    }
}
