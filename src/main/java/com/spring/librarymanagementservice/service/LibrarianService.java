package com.spring.librarymanagementservice.service;

import com.spring.librarymanagementservice.domain.LibrarianDataRequest;
import com.spring.librarymanagementservice.domain.LibrarianDataResponse;
import com.spring.librarymanagementservice.domain.ResponseStatus;
import com.spring.librarymanagementservice.model.Librarian;
import com.spring.librarymanagementservice.repository.LibrarianRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    private static final String RESPONSE_CODE_SUCCESS = "00";
    private static final String RESPONSE_STATUS_SUCCESS = "SUCCESS";

    public LibrarianDataResponse getLibrarianData(LibrarianDataRequest librarianDataRequest) {
        LibrarianDataResponse response = new LibrarianDataResponse();

        try {
            Librarian librarian = librarianRepository.findOneById(librarianDataRequest.getId());
            response = LibrarianDataResponse.builder()
                    .id(librarian.getId())
                    .name(librarian.getName())
                    .contact(librarian.getContact())
                    .address(librarian.getAddress())
                    .build();
        } catch (Exception ex) {
            log.error("Error when get librarian data {}", ex);
            throw ex;
        }
        log.info("response {} ", response);
        return response;
    }

    public List<LibrarianDataResponse> getAllLibrarianData(){
        List<LibrarianDataResponse> librarianDataResponses = new ArrayList<>();
        try {
            List<Librarian> librarians = librarianRepository.findAll();
            for (Librarian librarian : librarians) {
                LibrarianDataResponse librarianDataResponse = LibrarianDataResponse.builder()
                        .id(librarian.getId())
                        .name(librarian.getName())
                        .contact(librarian.getContact())
                        .address(librarian.getAddress())
                        .build();
                librarianDataResponses.add(librarianDataResponse);
            }
        } catch (Exception ex) {
            log.info("Error when get all librarian data {}", ex);
            throw ex;
        }
        log.info("librarianDataResponses {}", librarianDataResponses);
        return librarianDataResponses;
    }

    public ResponseStatus saveLibrarianData(LibrarianDataRequest librarianDataRequest){
        try {
            Librarian librarian = Librarian.builder()
                    .id(librarianDataRequest.getId())
                    .name(librarianDataRequest.getName())
                    .contact(librarianDataRequest.getContact())
                    .address(librarianDataRequest.getAddress())
                    .isDeleted(false)
                    .build();

            librarianRepository.save(librarian);
        } catch (Exception ex) {
            log.error("Error when save or update librarian data {}", ex);
            return ResponseStatus.builder()
                    .responseCode("01")
                    .responseMessage("Error when save librarian data")
                    .build();
        }

        return ResponseStatus.builder()
                .responseCode(RESPONSE_CODE_SUCCESS)
                .responseMessage(RESPONSE_STATUS_SUCCESS)
                .build();
    }

    public ResponseStatus updateLibrarianData(LibrarianDataRequest librarianDataRequest){
        try {
            Librarian librarian = librarianRepository.findOneById(librarianDataRequest.getId());
            if (librarian != null) {
                librarian.setName(librarianDataRequest.getName());
                librarian.setContact(librarianDataRequest.getContact());
                librarian.setAddress(librarianDataRequest.getAddress());
                librarianRepository.save(librarian);
            } else {
                throw new Exception("Data not found...");
            }

        } catch (Exception ex) {
            log.error("Error when update librarian data {}", ex);
            return ResponseStatus.builder()
                    .responseCode("02")
                    .responseMessage("Error when update librarian data")
                    .build();
        }

        return ResponseStatus.builder()
                .responseCode(RESPONSE_CODE_SUCCESS)
                .responseMessage(RESPONSE_STATUS_SUCCESS)
                .build();
    }
}
