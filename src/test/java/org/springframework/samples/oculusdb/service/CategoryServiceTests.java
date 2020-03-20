
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.CategoryService;

@SpringBootTest
public class CategoryServiceTests {

	@Autowired
	private CategoryService categoryService;

	@Test
	public void testCount() {
		int count = this.categoryService.categoryCount();
		Assertions.assertTrue(count > 0);
	}

}
