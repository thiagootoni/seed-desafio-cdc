package com.thiago.desafiocdc.repositories;

import com.thiago.desafiocdc.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    boolean existsByEmail(String email);
}
