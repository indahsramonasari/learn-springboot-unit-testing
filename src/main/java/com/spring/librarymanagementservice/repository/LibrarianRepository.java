package com.spring.librarymanagementservice.repository;

import com.spring.librarymanagementservice.model.Librarian;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, String> {

    @Query(value = "SELECT * FROM LIBRARIAN WHERE IS_DELETED = 0 AND ID=?1", nativeQuery = true)
    Librarian findOneById(String id);

    @Query(value = "SELECT * FROM LIBRARIAN WHERE IS_DELETED = 0", nativeQuery = true)
    List<Librarian> findAll();


}
