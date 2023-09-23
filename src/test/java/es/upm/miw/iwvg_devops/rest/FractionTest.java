package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction testFraction;

    @BeforeEach
    void before() {
        this.testFraction = new Fraction(2, 5);
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
    void testToString() {
        String message = "Fraction{" +
                "numerator=" + "2" +
                ", denominator=" + "5" +
                '}';
        assertEquals(message, testFraction.toString());
    }
}