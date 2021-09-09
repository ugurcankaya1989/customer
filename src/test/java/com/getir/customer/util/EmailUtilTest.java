package com.getir.customer.util;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailUtilTest {

    @Test
    void isEmailNotValid_test() {
        String email1 = "ugur.cankaya";
        String email2 = "ugur.cankaya@gmail.com";

        assertTrue(EmailUtil.isEmailNotValid(email1));
        assertFalse(EmailUtil.isEmailNotValid(email2));
    }
}
