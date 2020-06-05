
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.CategoryService;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CategoryServiceTests {

	@Autowired
	private CategoryService categoryService;

	@Test
	private void testCount() {
		int count = this.categoryService.categoryCount();
		Assertions.assertTrue(count >= 1);
	}

}
