package org.springframework.samples.oculusdb.web.e2e;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CommentsControllerE2ETests {

	private static final int TEST_APP_ID = 100;

	private static final int TEST_COMMENT_ID = 1001;

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser(username = "testuser")
	@Test
	void testInitAñadirComentarioSuccess() throws Exception {
		mockMvc.perform(get("/appInfo/{appId}/comments/new", TEST_APP_ID))
				.andExpect(status().isOk())
				.andExpect(view().name("comments/newComment"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testInitAñadirComentarioHasErrors() throws Exception {
		mockMvc.perform(get("/appInfo/{appId}/commentss/new", TEST_APP_ID))
				.andExpect(status().is4xxClientError());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAñadirComentarioSuccess() throws Exception {
		mockMvc.perform(post("/appInfo/{appId}/comments/new", TEST_APP_ID).with(csrf())
				.param("title", "Comentario de prueba").param("content", "Esto es una prueba"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/applications/appInfo/{appId}"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAñadirComentarioHasErrors() throws Exception {
		mockMvc.perform(
				post("/appInfo/{appId}/comments/new", TEST_APP_ID).with(csrf()).param("title", "").param("content", ""))
				.andExpect(model().attributeHasErrors("comments"))
				.andExpect(model().attributeHasFieldErrors("comments", "title"))
				.andExpect(model().attributeHasFieldErrors("comments", "content"))
				.andExpect(view().name("comments/newComment"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testBorrarComentarioSuccess() throws Exception {
		mockMvc.perform(get("/comments/delete", TEST_COMMENT_ID)).andExpect(status().isOk())
				.andExpect(view().name("applications/todoOk"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testListarComentariosSuccess() throws Exception {
		mockMvc.perform(get("/appInfo/{appId}/comments/list", TEST_APP_ID)).andExpect(status().isOk())
				.andExpect(view().name("comments/listComments"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testListarComentariosHasErrors() throws Exception {
		mockMvc.perform(get("/appInfo/{appId}/commentss/list", TEST_APP_ID)).andExpect(status().is4xxClientError());
	}

}
