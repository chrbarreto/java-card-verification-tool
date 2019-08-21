package br.com.chrbarreto.jpay.controller

import org.junit.Test

class CardSchemeControllerTest {

    @Test
    void verify() {
        CardSchemeController target = new CardSchemeController()
        target.verify 5149_4504_4785_3001L
    }
}
