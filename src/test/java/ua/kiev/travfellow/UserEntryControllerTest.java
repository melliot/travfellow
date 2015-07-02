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

import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserEntryControllerTest {
    @InjectMocks
    private UserEntryController controller;

    @Mock
    private UserEntryService service;

    private MockMvc mockMvc;

    private long id;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
         id = new Random().nextInt(55);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        UserEntry entry = new UserEntry();

        entry.setId(id);
        entry.setName("Name");

        System.out.println(id);
        when(service.find(id)).thenReturn(entry);

        mockMvc.perform(get("/rest/user/" + id)).andDo(print())
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/user/" + id))))
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingUserEntry() throws Exception {
        when(service.find(id)).thenReturn(null);

        mockMvc.perform(get("/rest/user/" + id)).andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    public void deleteExistingUserEntry() throws Exception {
        UserEntry deletedUserEntry = new UserEntry();
        deletedUserEntry.setId(1L);
        deletedUserEntry.setName("Test Name");

        when(service.delete(1L)).thenReturn(deletedUserEntry);

        mockMvc.perform(delete("/rest/user/1"))
                .andDo(print())
                .andExpect(jsonPath("$.name", is(deletedUserEntry.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/user/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNonExistingUserEntry() throws Exception {
        when(service.delete(1L)).thenReturn(null);

        mockMvc.perform(delete("/rest/user/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateExistingBlogEntry() throws Exception {
        UserEntry userEntry = new UserEntry();
        userEntry.setId(1L);
        userEntry.setName("Test name");

        when(service.update(eq(1L), any(UserEntry.class)))
                .thenReturn(userEntry);

        mockMvc.perform(put("/rest/user/1")
                .content("{\"title\":\"Test Title\"}")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(jsonPath("$.name", is(userEntry.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/user/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNonExistingUserEntry() throws Exception {
        when(service.update(eq(1L), any(UserEntry.class)))
                .thenReturn(null);

        mockMvc.perform(put("/rest/user/1")
                .content("{\"title\":\"Test Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}