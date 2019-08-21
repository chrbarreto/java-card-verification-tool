package br.com.chrbarreto.jpay.api

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

import org.junit.Test

import br.com.chrbarreto.jpay.model.CardDetails

class VerifyCardByNumberTest {

    @Test
    void verifyTest() {
        VerifyCardByNumber target = new VerifyCardByNumber()
        try {
            CardDetails response = target.verify 4571_7360L
            assertNotNull response
            assertEquals "Denmark", response.getCountry().getName()
            assertEquals "visa", response.getScheme()
            assertEquals "debit", response.getType()
            assertEquals "Jyske Bank", response.getBank().getName()
        } catch (IOException e) {
            throw new RuntimeException(e)
        }

    }

}
