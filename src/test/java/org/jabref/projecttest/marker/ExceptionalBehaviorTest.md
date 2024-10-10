package org.jabref.projecttest;
/* Copyright (C) 2024 <Peerapong Tantasilp> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionalBehaviorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrincipalThrowsException() {
        // Test case 3: testNegativePrincipalThrowsException
        // Goal: Test that negative principal throws IllegalArgumentException.
        // Characteristics:
        // - Interface-based: Principal is expected to be a positive value.
        // - Functionality-based: System handles invalid inputs.
        FinancialCalculator.simpleInterest(-1000, 0.05, 2);
    }

    @Test(expected = ArithmeticException.class)
    public void testZeroRateThrowsException() {
        // Test case 4: testZeroRateThrowsException
        // Goal: Test that a zero interest rate throws an ArithmeticException.
        // Characteristics:
        // - Interface-based: Rate must be positive.
        // - Functionality-based: Edge case handling.
        FinancialCalculator.simpleInterest(1000, 0, 2);
    }
}
