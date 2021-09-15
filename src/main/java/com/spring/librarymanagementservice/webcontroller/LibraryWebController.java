package com.spring.librarymanagementservice.webcontroller;

import com.spring.librarymanagementservice.domain.LibrarianDataRequest;
import com.spring.librarymanagementservice.domain.LibrarianDataResponse;
import com.spring.librarymanagementservice.service.LibrarianService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api
@Controller
@RequestMapping("/v1")
public class LibraryWebController {

    @Autowired
    LibrarianService librarianService;

    @PostMapping(value = "/getLibrarianDataById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LibrarianDataResponse getLibrarianDataById(@RequestBody LibrarianDataRequest librarianDataRequest) throws Exception {
        if (StringUtils.isEmpty(librarianDataRequest.getId())) {
            throw new Exception("librarian id shouldn't be null or empty");
        }
        return librarianService.getLibrarianData(librarianDataRequest);
    }

    @GetMapping(value = "/getAllLibrarianData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<LibrarianDataResponse> getAllLibrarianData(){
        return librarianService.getAllLibrarianData();
    }

    @PostMapping(value = "/saveLibrarianData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public com.spring.librarymanagementservice.domain.ResponseStatus saveLibrarianData(@RequestBody LibrarianDataRequest librarianDataRequest) {
        return librarianService.saveLibrarianData(librarianDataRequest);
    }

    @PostMapping(value = "/updateLibrarianData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public com.spring.librarymanagementservice.domain.ResponseStatus updateLibrarianData(@RequestBody LibrarianDataRequest librarianDataRequest) {
        return librarianService.updateLibrarianData(librarianDataRequest);
    }

}
