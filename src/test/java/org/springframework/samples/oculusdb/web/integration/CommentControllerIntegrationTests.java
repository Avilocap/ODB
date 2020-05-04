package org.springframework.samples.oculusdb.web.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.controllers.CommentsController;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.services.CommentsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import javax.xml.stream.events.Comment;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerIntegrationTests {

	private static final int TEST_APPLICATION_ID = 102;

	private static final int TEST_COMMENT_ID = 1001;

	@Autowired
	private CommentsController commentsController;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private ApplicationService applicationService;

	@Test
	void testInitAddComment() throws Exception {

		ModelMap model = new ModelMap();

		String view = commentsController.agregarProducto(TEST_APPLICATION_ID, model);
		Assertions.assertEquals(view, "comments/newComment");
		Assertions.assertNotNull(model.getAttribute("comment"));

	}

	@Test
	void testAddCommentSuccess() throws Exception {
		ModelMap model = new ModelMap();
		String app = "102";
		Comments comment = new Comments();
		comment.setTitle("comment");
		comment.setContent("a new comment for app");
		BindingResult bindingResult = new MapBindingResult(Collections.emptyMap(), "");

		String view = commentsController.guardarProducto(app, comment, bindingResult, model);

		Assertions.assertEquals(view, "redirect:/applications/appInfo/{appId}");

	}

	@Test
	void testAddCommentHasErrors1() throws Exception {

		ModelMap model = new ModelMap();
		String app = "102";
		Comments comment = new Comments();
		comment.setTitle("comment");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "");
		bindingResult.reject("content", "Required");

		String view = commentsController.guardarProducto(app, comment, bindingResult, model);

		Assertions.assertEquals(view, "comments/newComment");

	}

	@Test
	void testAddCommentHasErrors2() throws Exception {

		ModelMap model = new ModelMap();
		String app = "102";
		Comments comment = new Comments();
		comment.setContent("a new comment for app");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "");
		bindingResult.reject("title", "Required");

		String view = commentsController.guardarProducto(app, comment, bindingResult, model);

		Assertions.assertEquals(view, "comments/newComment");

	}

	@Test
	void testInitDeleteComment() throws Exception {
		String view = commentsController.borrarComentario(TEST_COMMENT_ID);
		Assertions.assertEquals(view, "applications/todoOk");
		Assertions.assertFalse(commentsService.findCommentById(TEST_COMMENT_ID).isPresent());
	}

	@Test
	void showCommentsSucces() throws Exception {
		ModelMap model = new ModelMap();
		String view = commentsController.listarComentarios(TEST_APPLICATION_ID, model);
		Assertions.assertEquals(view, "comments/listComments");
		Assertions.assertNotNull(model.getAttribute("comments"));
	}

}
