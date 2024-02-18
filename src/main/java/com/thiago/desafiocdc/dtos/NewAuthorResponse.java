package com.thiago.desafiocdc.dtos;

import com.thiago.desafiocdc.models.Author;

import java.io.Serializable;

public record NewAuthorResponse(String id) implements Serializable {

    public static NewAuthorResponse from(Author author){
        return new NewAuthorResponse(author.getId().toString());
    }
}
