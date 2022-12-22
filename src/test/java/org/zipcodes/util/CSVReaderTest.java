package org.zipcodes.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zipcodes.model.ZipCode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CSVReaderTest {
    private List<ZipCode> actualZipCodes;

    @BeforeEach
    void setUp() {
        actualZipCodes = CSVReader.readZipCodes("zipcodes_test.csv");
    }

    @Test
    public void readValidZipCodes() {
        ZipCode code = ZipCode.builder()
                .city("Schouweiler")
                .code("L-4968")
                .build();
        ZipCode code1 = ZipCode.builder()
                .city("Dippach")
                .code("L-4906")
                .build();
        assertTrue(actualZipCodes.contains(code));
        assertTrue(actualZipCodes.contains(code1));
    }


}