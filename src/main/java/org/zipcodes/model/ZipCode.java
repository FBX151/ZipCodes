package org.zipcodes.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ZipCode {
    private String code;
    private String city;
}
