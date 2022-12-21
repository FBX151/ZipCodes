package org.zipcodes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bidirectional map to quickly find city associated with Postal Code
 * And all postal codes of the city
 */
public class ZipCodeCityBiMap {

    private Map<String, List<String>> cityToPostalCodesMap;

    private Map<String, String> postalCodeToCityMap;

    public ZipCodeCityBiMap(List<ZipCode> zipCodeList) {
        cityToPostalCodesMap = new HashMap<>();
        postalCodeToCityMap = new HashMap<>();

        zipCodeList.forEach(zipCode -> {
            String city = zipCode.getCity();
            String code = zipCode.getCode();
            cityToPostalCodesMap.computeIfAbsent(city, k -> new ArrayList<>()).add(code);

            postalCodeToCityMap.put(code, city);
        });

        for (String city : cityToPostalCodesMap.keySet()) {
            System.out.println("city - " + city);
            System.out.println("cityToPostalCodesMap - " + cityToPostalCodesMap.get(city));
        }
    }

    public String getCityForZipCode(String code) {
        if (postalCodeToCityMap.containsKey(code)) {
            return postalCodeToCityMap.get(code);
        }
        throw new IllegalArgumentException("ZipCode is unknown - " + code);
    }

    public List<String> getZipCodesForCity(String city) {
        if (cityToPostalCodesMap.containsKey(city)) {
            return cityToPostalCodesMap.get(city);
        }
        throw new IllegalArgumentException("City is unknown - " + city);
    }
}
