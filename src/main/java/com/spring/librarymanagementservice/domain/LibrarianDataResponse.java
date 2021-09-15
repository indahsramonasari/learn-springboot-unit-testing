package com.spring.librarymanagementservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibrarianDataResponse implements Serializable {
    private static final long serialVersionUID = 963911200103075966L;

    private String id;
    private String name;
    private String contact;
    private String address;
}
