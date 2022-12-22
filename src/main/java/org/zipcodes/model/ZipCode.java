package org.zipcodes.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class ZipCode {
    private String code;
    private String city;
}
