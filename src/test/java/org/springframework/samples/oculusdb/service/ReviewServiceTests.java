
package org.springframework.samples.oculusdb.service;

import com.google.common.collect.Iterables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.application.Reviews;
import org.springframework.samples.oculusdb.services.ReviewService;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ReviewServiceTests {

	@Autowired
	private ReviewService reviewService;

	@Test
	private void testCount() {
		int count = this.reviewService.reviewCount();
		Assertions.assertTrue(count >= 0);
	}

	@Test
	private void testBasicProperties() {
		Iterable<Reviews> reviews = reviewService.reviewsList();
		Reviews review = Iterables.get(reviews, 0);
		review.getTitle();
		review.getId();
		review.getPublishDate();
		review.getContent();
		review.getOculusId();
		review.getApplication();
		review.toString();
	}

}
