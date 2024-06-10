package br.com.ramengo.api.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MissingBodyRequestException extends RuntimeException {

    public MissingBodyRequestException(String message){
        super(message);
    }
}