package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction testFraction, inputFraction;

    @BeforeEach
    void before() {
        this.testFraction = new Fraction(2, 5);
        this.inputFraction = new Fraction(4, 10);
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, testFraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(5, testFraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        Fraction newFraction = this.testFraction;
        newFraction.setNumerator(21);
        assertEquals(21, newFraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        Fraction newFraction = this.testFraction;
        newFraction.setDenominator(9);
        assertEquals(9, newFraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.4, testFraction.decimal());
    }

    @Test
    void testIsProper() {
        assertTrue(testFraction.isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(testFraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(testFraction.isEquivalent(inputFraction));
    }

    @Test
    void testAdd() {
        Fraction result = new Fraction(4, 5);
        assertTrue(result.isEquivalent(testFraction.add(inputFraction)));
    }

    @Test
    void testMultiply() {
        Fraction result = new Fraction(8, 50);
        assertTrue(result.isEquivalent(testFraction.multiply(inputFraction)));
    }

    @Test
    void testDivide() {
        Fraction result = new Fraction(1, 1);
        assertTrue(result.isEquivalent(testFraction.divide(inputFraction)));
    }

    @Test
    void testToString() {
        String message = "Fraction{" +
                "numerator=" + "2" +
                ", denominator=" + "5" +
                '}';
        assertEquals(message, testFraction.toString());
    }
}