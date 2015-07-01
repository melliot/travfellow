package ua.kiev.travfellow;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.kiev.travfellow.controller.BlogEntryController;
import ua.kiev.travfellow.controller.UserEntryController;
import ua.kiev.travfellow.entity.BlogEntry;
import ua.kiev.travfellow.entity.UserEntry;
import ua.kiev.travfellow.services.BlogEntryService;
import ua.kiev.travfellow.services.UserEntryService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserEntryControllerTest {
    @InjectMocks
    private UserEntryController controller;

    @Mock
    private UserEntryService service;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        UserEntry entry = new UserEntry();
        entry.setId(1L);
        entry.setName("Test Title");

        when(service.find(1L)).thenReturn(entry);

        mockMvc.perform(get("/rest/user/1"))
//                .andExpect(jsonPath("$.user", is(entry.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/user/1"))))
                .andExpect(status().isOk());
    }

//    @Test
//    public void getNonExistingBlogEntry() throws Exception {
//        when(service.find(1L)).thenReturn(null);
//
//        mockMvc.perform(get("/rest/blog-entries/1"))
//                .andExpect(status().isNotFound());
//    }
//
//
//    @Test
//    public void deleteExistingBlogEntry() throws Exception {
//        BlogEntry deletedBlogEntry = new BlogEntry();
//        deletedBlogEntry.setId(1L);
//        deletedBlogEntry.setTitle("Test Title");
//
//        when(service.delete(1L)).thenReturn(deletedBlogEntry);
//
//        mockMvc.perform(delete("/rest/blog-entries/1"))
//                .andExpect(jsonPath("$.title", is(deletedBlogEntry.getTitle())))
//                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void deleteNonExistingBlogEntry() throws Exception {
//        when(service.delete(1L)).thenReturn(null);
//
//        mockMvc.perform(delete("/rest/blog-entries/1"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void updateExistingBlogEntry() throws Exception {
//        BlogEntry updatedEntry = new BlogEntry();
//        updatedEntry.setId(1L);
//        updatedEntry.setTitle("Test Title");
//
//        when(service.update(eq(1L), any(BlogEntry.class)))
//                .thenReturn(updatedEntry);
//
//        mockMvc.perform(put("/rest/blog-entries/1")
//                .content("{\"title\":\"Test Title\"}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.title", is(updatedEntry.getTitle())))
//                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void updateNonExistingBlogEntry() throws Exception {
//        when(service.update(eq(1L), any(BlogEntry.class)))
//                .thenReturn(null);
//
//        mockMvc.perform(put("/rest/blog-entries/1")
//                .content("{\"title\":\"Test Title\"}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
}