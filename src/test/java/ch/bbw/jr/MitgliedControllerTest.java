package ch.bbw.jr;

import ch.bbw.jr.mitglied.Mitglied;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MitgliedControllerTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidMitglied() {
        Mitglied mitglied = new Mitglied();
        mitglied.setFirstName("John");
        mitglied.setLastName("Doe");
        mitglied.setAddress("Street 123");
        mitglied.setPhone("+41123456789");

        Set<ConstraintViolation<Mitglied>> violations = validator.validate(mitglied);
        assertEquals(0, violations.size());
    }

    @Test
    public void testInvalidFirstName() {
        Mitglied mitglied = new Mitglied();
        mitglied.setFirstName("John1");
        mitglied.setLastName("Doe");
        mitglied.setAddress("Street 123");
        mitglied.setPhone("+41123456789");

        Set<ConstraintViolation<Mitglied>> violations = validator.validate(mitglied);
        assertEquals(1, violations.size());
        assertEquals("First name should not contain numbers", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidLastName() {
        Mitglied mitglied = new Mitglied();
        mitglied.setFirstName("John");
        mitglied.setLastName("Doe1");
        mitglied.setAddress("Street 123");
        mitglied.setPhone("+41123456789");

        Set<ConstraintViolation<Mitglied>> violations = validator.validate(mitglied);
        assertEquals(1, violations.size());
        assertEquals("Last name should not contain numbers", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidAddress() {
        Mitglied mitglied = new Mitglied();
        mitglied.setFirstName("John");
        mitglied.setLastName("Doe");
        mitglied.setAddress("Street");
        mitglied.setPhone("+41123456789");

        Set<ConstraintViolation<Mitglied>> violations = validator.validate(mitglied);
        assertEquals(1, violations.size());
        assertEquals("Address should contain at least one letter and one number", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidPhone() {
        Mitglied mitglied = new Mitglied();
        mitglied.setFirstName("John");
        mitglied.setLastName("Doe");
        mitglied.setAddress("Street 123");
        mitglied.setPhone("123456789");

        Set<ConstraintViolation<Mitglied>> violations = validator.validate(mitglied);
        assertEquals(1, violations.size());
        assertEquals("Telefonnummer muss mit +41/0041 anfangen und 9 Stellen lang sein ", violations.iterator().next().getMessage());
    }
}
