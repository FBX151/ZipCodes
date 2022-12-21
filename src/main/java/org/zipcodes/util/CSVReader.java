package org.zipcodes.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;

import org.zipcodes.model.ZipCode;
import org.zipcodes.validator.ZipCodeValidator;

public class CSVReader {
    public static List<ZipCode> readZipCodes() {
        List<ZipCode> zipCodeList = new ArrayList<>();
        String csvFile = "zipcodes.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);
                if (values.length != 2) {
                    throw new IllegalArgumentException("Invalid input");
                }
                String code = ZipCodeValidator.validate(values[0]);
                String city = values[1];
                ZipCode zipCode = ZipCode.builder()
                                          .code(code)
                                          .city(city)
                                          .build();
                zipCodeList.add(zipCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return zipCodeList;
    }
}

