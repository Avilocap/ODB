
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.ReviewService;

@SpringBootTest
public class ReviewServiceTests {

	@Autowired
	private ReviewService reviewService;

	@Test
	public void testCount() {
		int count = this.reviewService.reviewCount();
		Assertions.assertEquals(count, 0);
	}

}
