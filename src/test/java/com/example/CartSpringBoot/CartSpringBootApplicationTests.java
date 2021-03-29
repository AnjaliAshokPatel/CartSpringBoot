package com.example.CartSpringBoot;

import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class CartSpringBootApplicationTests {

	@Autowired
	Service service;

	@Test
	void contextLoads() {
	}

	@Test
	void whenNonExistingProductsProvided() {
		Map<String,Integer> quantities = new HashMap<>();
		quantities.put("NONEXISTENT_PRODUCT",5);
		Assert.assertThrows(Exception.class, () -> service.calculateTotal(quantities));
	}

	@Test
	void whenExistingProductsProvided() throws Exception {
		Map<String,Integer> quantities = new HashMap<>();
		quantities.put("A",5);
		Map<String,Double> res = service.calculateTotal(quantities);
		Assert.assertEquals(3,res.size());
		Assert.assertEquals(java.util.Optional.of(0.0),java.util.Optional.of(res.getOrDefault("Discount Applied",0.0)));
	}

}
