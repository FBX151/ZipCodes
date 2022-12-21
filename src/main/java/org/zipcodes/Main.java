package org.zipcodes;

import java.util.List;

import org.zipcodes.model.ZipCode;
import org.zipcodes.model.ZipCodeCityBiMap;
import org.zipcodes.util.CSVReader;

public class Main {

    public static void main(String[] args) {

        List<ZipCode> zipCodeList = CSVReader.readZipCodes();
        System.out.println("number of zipcodes - " + zipCodeList.size());
        ZipCodeCityBiMap zipCodeCityBiMap = new ZipCodeCityBiMap(zipCodeList);

        System.out.println("City of ZipCode - L-7599 - " + zipCodeCityBiMap.getCityForZipCode("L-7599"));
        System.out.println("ZipCodes of Ettelbruck - " + zipCodeCityBiMap.getZipCodesForCity("Ettelbruck"));
        System.out.println();

    }

}
