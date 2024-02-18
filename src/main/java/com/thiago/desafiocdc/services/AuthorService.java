package com.thiago.desafiocdc.services;

import com.thiago.desafiocdc.dtos.AuthorRequest;
import com.thiago.desafiocdc.dtos.NewAuthorResponse;
import com.thiago.desafiocdc.models.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    public NewAuthorResponse create(AuthorRequest authorRequest){
        var author = Author.from(authorRequest);
//        authorRepository.save(author);
        return NewAuthorResponse.from(author);
    }
}
