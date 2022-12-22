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

            if(!cityToPostalCodesMap.containsKey(city)) {
                cityToPostalCodesMap.put(city, new ArrayList<>());
            }
            cityToPostalCodesMap.get(city).add(code);

            postalCodeToCityMap.put(code, city);
        });
    }

    /**
     * This method returns the city by code, if it contains in our file.
     * If not it will throw an exception.
     * @param code
     * @return
     */
    public String getCityForZipCode(String code) {
        if (postalCodeToCityMap.containsKey(code)) {
            return postalCodeToCityMap.get(code);
        }
        throw new IllegalArgumentException("ZipCode is unknown - " + code);
    }

    /**
     * This method returns the list of codes by city, if city contains in our file.
     * If not it will throw an exception
     * @param city
     * @return
     */
    public List<String> getZipCodesForCity(String city) {
        if (cityToPostalCodesMap.containsKey(city)) {
            return cityToPostalCodesMap.get(city);
        }
        throw new IllegalArgumentException("City is unknown - " + city);
    }
}
