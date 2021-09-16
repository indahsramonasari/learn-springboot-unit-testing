package com.spring.librarymanagementservice.service;

import com.spring.librarymanagementservice.domain.LibrarianDataRequest;
import com.spring.librarymanagementservice.domain.LibrarianDataResponse;
import com.spring.librarymanagementservice.domain.ResponseStatus;
import com.spring.librarymanagementservice.model.Librarian;
import com.spring.librarymanagementservice.repository.LibrarianRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles()
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Slf4j
@DirtiesContext
public class LibrarianServiceTest {

    @Autowired
    LibrarianService librarianService;

    @MockBean
    LibrarianRepository librarianRepository;

    @Test
    public void getLibrarianDataTest(){
        Mockito.when(librarianRepository.findOneById("123XXX")).thenReturn(Librarian.builder()
                .id("123XXX")
                .name("Lala")
                .contact("62289927181")
                .address("Jl. Mangga")
                .isDeleted(false)
                .build());

        LibrarianDataResponse response = librarianService.getLibrarianData(LibrarianDataRequest.builder()
                .id("123XXX")
                .build());
        assertNotNull(response);
    }

    @Test
    public void getAllLibrarianDataTest(){
        Mockito.when(librarianRepository.findAll()).thenReturn(List.of(Librarian.builder()
                .id("123XXX")
                .name("Lala")
                .contact("62289927181")
                .address("Jl. Mangga")
                .isDeleted(false)
                .build()));
        List<LibrarianDataResponse> responses = librarianService.getAllLibrarianData();

        assertNotNull(responses);
    }

    @Test
    public void saveLibrarianDataTest(){
        ResponseStatus response = librarianService.saveLibrarianData(LibrarianDataRequest.builder()
                .id("321XXX")
                .name("Suga")
                .contact("64253462728")
                .address("Itaewon")
                .build());

        assertNotNull(response);
    }

    @Test
    public void updateLibrarianDataTest(){
        Mockito.when(librarianRepository.findOneById("321XXX"))
                .thenReturn(Librarian.builder()
                        .id("321XXX")
                        .name("Suga")
                        .contact("64253462728")
                        .address("Itaewon")
                        .isDeleted(false)
                        .build());

        ResponseStatus response = librarianService.updateLibrarianData(LibrarianDataRequest.builder()
                .id("321XXX")
                .name("Min Suga")
                .contact("64253462728")
                .address("Itaewon")
                .build());

        assertNotNull(response);
    }

}
