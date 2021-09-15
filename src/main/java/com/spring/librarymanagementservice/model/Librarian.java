package com.spring.librarymanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LIBRARIAN")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

}
