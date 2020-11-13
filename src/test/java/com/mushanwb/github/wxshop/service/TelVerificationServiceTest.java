package com.mushanwb.github.wxshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelVerificationServiceTest {

    public static String VALID_TEL = "13800000000";
    public static String NOT_TEL = null;
    public static String VALID_CODE = "000000";

    @Test
    public void returnTrueIfValid() {
        Assertions.assertTrue(new TelVerificationService().verifyTelParameter(VALID_TEL));
    }

    @Test
    public void returnFalseIfNotTel() {
        Assertions.assertFalse(new TelVerificationService().verifyTelParameter(NOT_TEL));
    }

}
