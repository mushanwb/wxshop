package com.mushanwb.github.wxshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TelVerificationServiceTest {

    @Test
    public void returnTrueIfValid() {
        Assertions.assertTrue(new TelVerificationService().verifyTelParameter("13812345678"));
    }

    @Test
    public void returnFalseIfNotTel() {
        Assertions.assertFalse(new TelVerificationService().verifyTelParameter(null));
    }

}
