package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Search;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void testFindFirstProperFractionByUserId() {
        Fraction fraction = new Fraction(-1, 5);
        assertTrue(new Search().findFirstProperFractionByUserId("2").isEquivalent(fraction));
    }

    @Test
    void testNotFindFirstProperFractionByUserId() {
        Fraction fraction = new Fraction(0, 1);
        assertFalse(new Search().findFirstProperFractionByUserId("3").isEquivalent(fraction));
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertEquals(List.of(), new Search().findUserIdByAllProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindFirstDecimalFractionByUserName() {
        Double result = 2.0;
        assertEquals(result, new Search().findFirstDecimalFractionByUserName("Ana"));
    }

    @Test
    void testNoFindFirstDecimalFractionByUserName() {
        Double result = 3.0;
        assertNotEquals(result, new Search().findFirstDecimalFractionByUserName("Ana"));
    }

}
