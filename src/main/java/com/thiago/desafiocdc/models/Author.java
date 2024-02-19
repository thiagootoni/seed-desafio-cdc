package com.thiago.desafiocdc.models;

import com.thiago.desafiocdc.dtos.AuthorRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Author {
    @Id
    private UUID id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique=true)
    private String email;
    @NotBlank(message = "Description is mandatory")
    @Size(max = 400, message = "Description can't exceed 400 characters")
    private String description;
    @NotNull(message = "Instant can't be null")
    private Instant createdAt;

    private Author(){}

    private Author(UUID id, String name, String email, String description, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static Author create(String name, String email, String description){
        return new Author(UUID.randomUUID(), name, email, description, Instant.now());
    }

    public static Author from(AuthorRequest authorRequest){
        return create(authorRequest.name(), authorRequest.email(), authorRequest.description());
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
