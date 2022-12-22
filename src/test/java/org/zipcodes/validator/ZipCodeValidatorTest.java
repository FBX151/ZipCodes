package org.zipcodes.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZipCodeValidatorTest {

    @Test
    public void testValidZipCode() {
        assertEquals("L-4974", ZipCodeValidator.validate("L-4974"));
    }

    @Test
    public void testInvalidZipCode() {
        assertThrows(IllegalArgumentException.class, () -> ZipCodeValidator.validate("L-497F"));
    }
}