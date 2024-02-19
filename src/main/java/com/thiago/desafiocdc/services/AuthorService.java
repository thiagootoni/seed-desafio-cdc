package com.thiago.desafiocdc.services;

import com.thiago.desafiocdc.dtos.AuthorRequest;
import com.thiago.desafiocdc.dtos.NewAuthorResponse;
import com.thiago.desafiocdc.models.Author;
import com.thiago.desafiocdc.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
// 4 pts
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public NewAuthorResponse create(AuthorRequest authorRequest){

        if(authorRepository.existsByEmail(authorRequest.email()))
            throw new IllegalArgumentException("Email %s already use".formatted(authorRequest.email()));

        var author = Author.from(authorRequest);
        authorRepository.save(author);
        return NewAuthorResponse.from(author);
    }
}
