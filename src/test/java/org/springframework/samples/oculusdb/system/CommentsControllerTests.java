package org.springframework.samples.oculusdb.system;


import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.oculusdb.controllers.ApplicationController;
import org.springframework.samples.oculusdb.controllers.CommentsController;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.services.CommentsService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CommentsControllerTests {

    private static final int TEST_APP_ID = 2;

    @Autowired
    private CommentsController commentsController;

    @MockBean
    private CommentsService commentsService;

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser("testuser")
    @Test
    void testInitAddComment() throws Exception {
        mockMvc.perform(get("/appInfo/{appId}/comments/new", TEST_APP_ID))
                .andExpect(status().isOk())
                .andExpect(view().name("comments/newComment"));
    }

    @WithMockUser("testuser")
    @Test
    void testAddCommentSuccess() throws Exception {
        mockMvc.perform(post("/appInfo/{appId}/comments/new", TEST_APP_ID)
                .param("title", "Comment1")
                .param("content", "This is a new comment"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/applications/appInfo/{appId}"));
    }

    @WithMockUser("testuser")
    @Test
    void testAddCommentHasErrors() throws Exception {
        mockMvc.perform(post("/appInfo/{appId}/comments/new", TEST_APP_ID).with(csrf()).param("title", "Comment1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("comments"))
                .andExpect(model().attributeHasFieldErrors("comments", "content"))
                .andExpect(view().name("comments/newComment"));
    }

    @WithMockUser("testuser")
    @Test
    void testShowCommentsList() throws Exception {
        mockMvc.perform(get("/appInfo/{appId}/comments/list", TEST_APP_ID))
                .andExpect(status().isOk())
                .andExpect(view().name("comments/listComments"));
    }

    @WithMockUser("testuser")
    @Test
    void testShowCommentsListHasErrors() throws Exception {
        mockMvc.perform(get("/appInfo/{appId}/comments/list", TEST_APP_ID))
                .andExpect(status().isOk())
                .andExpect(model().attributeDoesNotExist("commentss"))
                .andExpect(view().name("comments/listComments"));
    }



}

