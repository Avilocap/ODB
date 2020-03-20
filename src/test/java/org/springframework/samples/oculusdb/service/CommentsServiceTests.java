
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.CommentsService;

@SpringBootTest
public class CommentsServiceTests {

	@Autowired
	private CommentsService commentsService;

	@Test
	public void testCount() {
		int count = this.commentsService.commentsCount();
		Assertions.assertTrue(count >= 0);
	}

}
