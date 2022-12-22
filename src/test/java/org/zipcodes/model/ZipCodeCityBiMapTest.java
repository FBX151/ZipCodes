package org.zipcodes.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipCodeCityBiMapTest {
    private ZipCodeCityBiMap zipCodeCityBiMap;
    private List<ZipCode> zipCodeList = new ArrayList<>();
    private ZipCode zipCode;

    @Test
    void getCityForZipCode() {
        zipCode = ZipCode.builder().city("Tandel").code("L-9395").build();
        zipCodeList.add(zipCode);

        zipCode = ZipCode.builder().city("Oberwampach").code("L-9673").build();
        zipCodeList.add(zipCode);

        zipCode = ZipCode.builder().city("Colpach-Bas").code("L-8526").build();
        zipCodeList.add(zipCode);

        zipCode = ZipCode.builder().city("Colpach-Bas").code("L-8527").build();
        zipCodeList.add(zipCode);

        zipCodeCityBiMap = new ZipCodeCityBiMap(zipCodeList);
        String city = zipCodeCityBiMap.getCityForZipCode("L-9673");
        assertEquals("Oberwampach", city);
    }

    @Test
    void testGetZipCodesForCity() {
        zipCode = ZipCode.builder().city("Tandel").code("L-9395").build();
        zipCodeList.add(zipCode);

        zipCode = ZipCode.builder().city("Oberwampach").code("L-9673").build();
        zipCodeList.add(zipCode);

        zipCode = ZipCode.builder().city("Colpach-Bas").code("L-8526").build();
        zipCodeList.add(zipCode);

        zipCode = ZipCode.builder().city("Colpach-Bas").code("L-8527").build();
        zipCodeList.add(zipCode);
        zipCodeCityBiMap = new ZipCodeCityBiMap(zipCodeList);


        List<String> code = zipCodeCityBiMap.getZipCodesForCity("Colpach-Bas");
        assertEquals("L-8526", code.get(0));
        assertEquals("L-8527", code.get(1));
    }
}