package com.cmplxsoftsys.team3.financeapplication.modeltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.cmplxsoftsys.team3.financeapplication.model.LoanApplication;

import org.junit.jupiter.api.Test;

public class LoanApplicationTests {

    private String type = "testtype";
    private double amount = 12345.67;
    private String userId = "testid";

    
    @Test
    public void objectCanBeInstantiated() {
        LoanApplication testInstance = new LoanApplication(type, amount, userId);
        assertThat(testInstance).isNotNull();
    }


    @Test
    public void instanceCorrectlyReturnsAttributeValuesWithGets() throws Exception {
        LoanApplication testInstance = new LoanApplication(type, amount, userId);
        assertThat(testInstance.getType()).isEqualTo(type);
        assertThat(testInstance.getAmount()).isEqualTo(amount);
        assertThat(testInstance.getUserId()).isEqualTo(userId);
    }
}
