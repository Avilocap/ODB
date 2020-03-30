
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.services.CommentsService;

import java.util.Collection;
import java.util.Optional;

@SpringBootTest
public class CommentsServiceTests {

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testCount() {
		int count = this.commentsService.commentsCount();
		Assertions.assertTrue(count >= 0);
	}

	@Test
	public void shouldAddNewCommentForApplication() {

		Application app2 = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(2);
		if (ap2.isPresent()) {
			app2 = ap2.get();
		}

		int found = app2.getComments().size();
		Comments comment = new Comments();
		app2.addComment(comment);
		comment.setTitle("jajaaj");
		comment.setContent("this is a new comment");
		this.commentsService.saveComment(comment);

		ap2 = this.applicationService.findApplicationById(2);
		if (ap2.isPresent()) {
			app2 = ap2.get();
		}
		Assertions.assertEquals(found + 1, app2.getComments().size());
	}

	@Test
	void shouldAddCommentWithAppId() {

		Application app2 = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(2);
		if (ap2.isPresent()) {
			app2 = ap2.get();
		}

		Comments comment = new Comments();
		app2.addComment(comment);
		comment.setTitle("jajaaj");
		comment.setContent("this is a new comment");
		this.commentsService.saveComment(comment);

		Assertions.assertEquals(2, comment.getApplication().getId());
	}

	@Test
	void AddCommentWithRandomAppId() {
		Application app2 = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(276);
		if (ap2.isPresent()) {
			app2 = ap2.get();
			Comments comment = new Comments();
			app2.addComment(comment);
			comment.setTitle("jajaaj");
			comment.setContent("this is a new comment");
			this.commentsService.saveComment(comment);
		}
		else {
			app2 = null;
		}
		Assertions.assertNull(app2);
	}

	@Test
	void shouldFindCommentByAppId() {
		Collection<Comments> comments = (Collection<Comments>) this.commentsService.findAllByAplicationId(3);
		Assertions.assertEquals(1, comments.size());

	}

	@Test
	void FindCommentByRandomAppId() {
		Collection<Comments> comments = (Collection<Comments>) this.commentsService.findAllByAplicationId(276);
		Assertions.assertEquals(0, comments.size());
	}

}
