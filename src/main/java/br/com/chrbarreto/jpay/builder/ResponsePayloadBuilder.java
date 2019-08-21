package br.com.chrbarreto.jpay.builder;

import br.com.chrbarreto.jpay.model.CardDetails;
import br.com.chrbarreto.jpay.model.Payload;

public class ResponsePayloadBuilder {

    private CardDetails cardDetails;
    private String scheme, type, bank;

    public ResponsePayloadBuilder(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public ResponsePayloadBuilder withScheme() {
        this.scheme = this.cardDetails.getScheme();
        return this;
    }

    public ResponsePayloadBuilder withType() {
        this.type = this.cardDetails.getType();
        return this;
    }

    public ResponsePayloadBuilder withBank() {
        this.bank = this.cardDetails.getBank().getName();
        return this;
    }

    // TODO: implementation for other possible properties

    public Payload build() {
        Payload payload = new Payload(this.scheme, this.type, this.bank);
        return payload;
    }
}
