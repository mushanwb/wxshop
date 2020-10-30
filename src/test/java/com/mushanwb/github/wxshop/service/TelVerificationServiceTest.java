package com.mushanwb.github.wxshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TelVerificationServiceTest {

    public static String VALID_TEL = "13812345678";
    public static String NOT_TEL = null;

    @Test
    public void returnTrueIfValid() {
        Assertions.assertTrue(new TelVerificationService().verifyTelParameter(VALID_TEL));
    }

    @Test
    public void returnFalseIfNotTel() {
        Assertions.assertFalse(new TelVerificationService().verifyTelParameter(NOT_TEL));
    }

}
