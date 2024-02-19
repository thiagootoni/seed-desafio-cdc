package com.thiago.desafiocdc.controllers;

import com.thiago.desafiocdc.dtos.AuthorRequest;
import com.thiago.desafiocdc.dtos.NewAuthorResponse;
import com.thiago.desafiocdc.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authors")
// 3 pts
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public ResponseEntity<NewAuthorResponse> createAuthor(@RequestBody @Valid AuthorRequest authorRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(authorRequest));
    }
}
