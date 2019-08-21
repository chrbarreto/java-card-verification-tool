package br.com.chrbarreto.jpay.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chrbarreto.jpay.api.VerifyCardByNumber;
import br.com.chrbarreto.jpay.builder.ResponsePayloadBuilder;
import br.com.chrbarreto.jpay.model.CardDetails;
import br.com.chrbarreto.jpay.model.Payload;
import br.com.chrbarreto.jpay.model.ResponseBody;

@RestController
public class CardSchemeController {

    private VerifyCardByNumber verifyCardByNumber = new VerifyCardByNumber();

    @RequestMapping(value = "/card-scheme/verify/{cardNumber}", method = GET)
    public ResponseBody verify(@PathVariable Long cardNumber) {
        ResponseBody response = new ResponseBody();
        System.out.println("given card number: " + cardNumber);

        try {
            CardDetails cardDetails = verifyCardByNumber.verify(cardNumber);
            Payload payload = new ResponsePayloadBuilder(cardDetails).withBank().withScheme().withType().build();
            response.setSuccess(true);
            response.setPayload(payload);
        } catch (IOException e) {
            response.setSuccess(false);
        }
        return response;
    }

}
