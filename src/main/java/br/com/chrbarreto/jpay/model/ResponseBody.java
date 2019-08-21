package br.com.chrbarreto.jpay.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody {

    private boolean success = true;
    private Payload payload = new Payload();

}
