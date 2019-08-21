package br.com.chrbarreto.jpay.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardCountry {
    private Integer numeric;
    private Double latitude, longitude;
    private String alpha2, name, emoji, currency;

}
