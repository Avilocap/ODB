
package org.springframework.samples.oculusdb.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.services.CommentsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class CommentsServiceTests {

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testCount() {
		int count = this.commentsService.commentsCount();
		Assertions.assertTrue(count >= 1);
	}

	int randomIdAppendix = 425245;

	@Test
	public void shouldAddNewCommentForApplication() {

		Application app2 = new Application();
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		Optional<Application> ap2 = this.applicationService.findApplicationById(apps.get(2).getId());

		if (ap2.isPresent()) {
			app2 = ap2.get();
		}

		Comments comment = new Comments();
		app2.addComment(comment);
		comment.setTitle("Title");
		comment.setContent("this is a new comment");
		this.commentsService.saveComment(comment);

		ap2 = this.applicationService.findApplicationById(101);
		if (ap2.isPresent()) {
			app2 = ap2.get();
		}
		Assertions.assertEquals(1, app2.getComments().size());
	}

	@Test
	void shouldAddCommentWithAppId() {

		Application app2 = new Application();
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		Optional<Application> ap2 = this.applicationService.findApplicationById(apps.get(2).getId());
		if (ap2.isPresent()) {
			app2 = ap2.get();
		}

		Comments comment = new Comments();
		app2.addComment(comment);
		comment.setTitle("Title");
		comment.setContent("this is a new comment");
		this.commentsService.saveComment(comment);

		Assertions.assertEquals(apps.get(2).getId(), comment.getApplication().getId());
	}

	@Test
	void AddCommentWithRandomAppId() {
		Application app2 = new Application();
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		Optional<Application> ap2 = this.applicationService.findApplicationById(apps.get(2).getId());
		if (ap2.isPresent()) {
			app2 = ap2.get();
			Comments comment = new Comments();
			app2.addComment(comment);
			comment.setTitle("Title");
			comment.setContent("this is a new comment");
			this.commentsService.saveComment(comment);
		}
		else {
			app2 = null;
		}
		Assertions.assertNotNull(app2);
	}

	@Test
	void shouldFindCommentByAppId() {
		Collection<Comments> comments = (Collection<Comments>) this.commentsService.findAllByAplicationId(101);
		Assertions.assertTrue(comments.size() >= 1);
	}

	@Test
	public void findCommentByAppIdNegative() {
		Collection<Comments> comments = (Collection<Comments>) this.commentsService.findAllByAplicationId(38282383);
		Assertions.assertTrue(comments.isEmpty());
	}

	@Test
	void FindCommentByRandomAppId() {
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		Collection<Comments> comments = (Collection<Comments>) this.commentsService
				.findAllByAplicationId(apps.get(0).getId());
		Assertions.assertTrue(comments.size() >= 1);
	}

	@Test
	void FindCommentByRandomAppIdNegative() {
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		Application app = apps.get(0);
		Collection<Comments> comments = app.getComments();
		app.getComments().removeAll(comments);
		this.applicationService.saveApplication(app);
		Collection<Comments> commentsFinal = (Collection<Comments>) this.commentsService
				.findAllByAplicationId(app.getId() + randomIdAppendix);
		Assert.assertEquals(0, commentsFinal.size());

	}

	@Test
	public void shouldAddNewCommentForApplicationNegative() {
		Assertions.assertThrows(NullPointerException.class, () -> {

			Application app2 = new Application();
			List<Application> apps = new ArrayList<>(
					(Collection<? extends Application>) this.applicationService.findAll());
			Optional<Application> ap2 = this.applicationService
					.findApplicationById(apps.get(2).getId() + randomIdAppendix);
			if (ap2.isPresent()) {
				app2 = ap2.get();
			}

			Comments comment = new Comments();
			app2.addComment(comment);
			comment.setTitle("Title");
			comment.setContent("this is a new comment");
			this.commentsService.saveComment(comment);

			ap2 = this.applicationService.findApplicationById(apps.get(2).getId() + randomIdAppendix);
			if (ap2.isPresent()) {
				ap2.get();
			}
		});
	}

	@Test
	void shouldAddCommentWithAppIdNegative() {
		Assertions.assertThrows(NullPointerException.class, () -> {

			Application app2 = new Application();
			List<Application> apps = new ArrayList<>(
					(Collection<? extends Application>) this.applicationService.findAll());
			Optional<Application> ap2 = this.applicationService
					.findApplicationById(apps.get(2).getId() + randomIdAppendix);
			if (ap2.isPresent()) {
				app2 = ap2.get();
			}

			Comments comment = new Comments();
			app2.addComment(comment);
			comment.setTitle("Title");
			comment.setContent("this is a new comment");
			this.commentsService.saveComment(comment);

		});

	}

	@Test
	void AddCommentWithRandomAppIdNegative() {
		Application app2 = new Application();
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		Optional<Application> ap2 = this.applicationService.findApplicationById(apps.get(2).getId() + randomIdAppendix);
		if (ap2.isPresent()) {
			app2 = ap2.get();
			Comments comment = new Comments();
			app2.addComment(comment);
			comment.setTitle("Title");
			comment.setContent("this is a new comment");
			this.commentsService.saveComment(comment);
		}
		else {
			app2 = null;
		}
		Assertions.assertNull(app2);
	}

	@Test
	public void shouldFindCommentById() {
		Optional<Comments> comment = this.commentsService.findCommentById(1001);
		Assertions.assertNotNull(comment);
	}

	@Test
	public void shouldFindCommentByIdNegative() {
		Optional<Comments> comment = this.commentsService.findCommentById(100001);
		Assertions.assertFalse(comment.isPresent());
	}

	@Test
	void shouldByDeleteComment() {
		Collection<Comments> comments = (Collection<Comments>) this.commentsService.findAllByAplicationId(100);
		Optional<Comments> comment = this.commentsService.findCommentById(1001);

		Comments comment1 = new Comments();
		if (comment.isPresent()) {
			comment1 = comment.get();
		}
		this.commentsService.deleteComment(comment1);

		Collection<Comments> comments2 = (Collection<Comments>) this.commentsService.findAllByAplicationId(100);
		Assertions.assertEquals(comments.size() - 1, comments2.size());
	}

	@Test
	void shouldByDeleteCommentNegative() {
		Collection<Comments> comments = (Collection<Comments>) this.commentsService.findAllByAplicationId(100);
		Optional<Comments> comment = this.commentsService.findCommentById(100000000);

		Comments comment1 = new Comments();
		if (comment.isPresent()) {
			comment1 = comment.get();
		}
		this.commentsService.deleteComment(comment1);

		Collection<Comments> comments2 = (Collection<Comments>) this.commentsService.findAllByAplicationId(100);
		Assertions.assertNotEquals(comments.size() - 1, comments2.size());
	}

}
