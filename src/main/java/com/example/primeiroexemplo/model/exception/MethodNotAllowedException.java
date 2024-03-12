package com.example.primeiroexemplo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RuntimeException{

    public MethodNotAllowedException(String mensagem){
        super(mensagem);
    }
}
