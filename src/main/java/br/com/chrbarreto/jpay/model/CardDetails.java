package br.com.chrbarreto.jpay.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDetails {
    private String scheme;
    private String type;
    private String brand;
    private Boolean prepaid;

    private CardNumber number;
    private CardCountry country;
    private CardBank bank;

}
