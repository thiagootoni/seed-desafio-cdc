package com.thiago.desafiocdc.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record AuthorRequest(
        @NotBlank(message = "Author name is required")
        @Size(max = 255, message = "Author name cannot be longer than 255 characters")
        String name,

        @NotBlank(message = "Author email is required")
        @Email(message = "Author email must be valid")
        String email,

        @NotBlank(message = "Author description is required")
        @Size(max = 400, message = "Author description cannot be longer than 400 characters")
        String description
) implements Serializable {}