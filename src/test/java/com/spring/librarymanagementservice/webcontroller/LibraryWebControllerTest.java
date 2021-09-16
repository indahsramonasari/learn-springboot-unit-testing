package com.spring.librarymanagementservice.webcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.librarymanagementservice.LibraryManagementServiceApplication;
import com.spring.librarymanagementservice.domain.LibrarianDataRequest;
import com.spring.librarymanagementservice.service.LibrarianService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryManagementServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LibraryWebControllerTest {

    @Autowired
    LibraryWebController libraryWebController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LibrarianService librarianService;

    @Test
    public void getLibrarianDataByIdTest() throws Exception {
        this.mockMvc.perform(post("/v1/getLibrarianDataById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(LibrarianDataRequest.builder().id("123XX2").build()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveLibrarianDataTest() throws Exception {
        LibrarianDataRequest librarianDataRequest = LibrarianDataRequest.builder()
                .id("123XX2")
                .name("Suga")
                .contact("7827282627")
                .address("Baverly Hills")
                .build();
        this.mockMvc.perform(post("/v1/saveLibrarianData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(librarianDataRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateLibrarianDataTest() throws Exception {
        LibrarianDataRequest librarianDataRequest = LibrarianDataRequest.builder()
                .id("123XX2")
                .name("Suga")
                .contact("7827282627")
                .address("Baverly Hills")
                .build();
        this.mockMvc.perform(post("/v1/updateLibrarianData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(librarianDataRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
