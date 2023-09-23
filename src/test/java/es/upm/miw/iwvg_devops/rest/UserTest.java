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
        testFractions = new ArrayList<>();
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
