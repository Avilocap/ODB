
package org.springframework.samples.oculusdb.service;

import java.security.Provider.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.oculusdb.services.CategoryService;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class CategoryServiceTests {

	@Autowired
	private CategoryService categoryService;


	@Test
	public void testCount() {
		int count = this.categoryService.categoryCount();
		Assertions.assertEquals(count, 1);
	}

}
