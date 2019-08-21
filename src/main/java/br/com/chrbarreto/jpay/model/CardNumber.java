package br.com.chrbarreto.jpay.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardNumber {
    private Integer length;
    private Boolean luhn;
}
