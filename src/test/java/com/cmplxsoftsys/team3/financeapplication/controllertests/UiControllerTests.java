package com.cmplxsoftsys.team3.financeapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cmplxsoftsys.team3.financeapplication.controller.UiController;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class UiControllerTests {
    @Autowired
    private UiController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void validReturn() {
        assertEquals("index", controller.getHomepage());
    }
}
