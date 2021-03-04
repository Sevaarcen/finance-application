package com.cmplxsoftsys.team3.financeapplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FinanceapplicationApplicationTests {

	@Autowired
    private WebApplicationContext context;

	
	@Test
	void contextLoads() {
		assertThat(context).isNotNull();
	}
}
