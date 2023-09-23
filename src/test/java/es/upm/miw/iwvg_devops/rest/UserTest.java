package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private List<Fraction> testFractions;
    private User testUser;

    @BeforeEach
    void before() {
        testFractions = List.of(
                new Fraction(1, 2),
                new Fraction(3, 4),
                new Fraction(9, 8),
                new Fraction(-1, 7)
        );
        testUser = new User("testId", "testName", "testFamilyName", testFractions);
    }

    @Test
    void testGetId() {
        assertEquals("testId", testUser.getId());
    }

    @Test
    void testGetName() {
        assertEquals("testName", testUser.getName());
    }

    @Test
    void testSetName() {
        testUser.setName("newTestName");
        assertEquals("newTestName", testUser.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("testFamilyName", testUser.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        testUser.setFamilyName("newTestFamilyName");
        assertEquals("newTestFamilyName", testUser.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(testFractions, testUser.getFractions());
    }

    @Test
    void testSetFractions() {
        List<Fraction> testNewFractions = List.of(
                new Fraction(7, 4),
                new Fraction(4, 9)
        );
        testUser.setFractions(testNewFractions);
        assertEquals(testNewFractions, testUser.getFractions());
    }

    @Test
    void testAddFraction() {
        List<Fraction> fractionsArray = new ArrayList<Fraction>();
        fractionsArray.add(new Fraction(1, 3));
        fractionsArray.add(new Fraction(1, 4));
        testUser = new User("TestID", "TestName", "TestFamilyName", fractionsArray);
        Fraction newFraction = new Fraction(3, 1);
        testUser.addFraction(newFraction);
        assertEquals(newFraction, testUser.getFractions().get(2));
    }

    @Test
    void testFullName() {
        assertEquals("testName testFamilyName", testUser.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("t.", testUser.initials());
    }

    @Test
    void testToString() {
        String message = "User{" +
                "id='" + "testId" + '\'' +
                ", name='" + "testName" + '\'' +
                ", familyName='" + "testFamilyName" + '\'' +
                ", fractions=" + testUser.getFractions() +
                '}';
        assertEquals(message, testUser.toString());
    }
}
