package com.returnorder.PaymentServices;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRunner.class)
@ContextConfiguration
class PaymentServicesApplicationTests {
	
	@Test
	public void contextLoads() {
	
		PaymentServicesApplication.main(new String[] {});
		
	}
	
}
