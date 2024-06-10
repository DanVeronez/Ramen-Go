package br.com.ramengo.api.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class MissingApiKeyExcepiton extends RuntimeException{

    public MissingApiKeyExcepiton(String message){
        super(message);
    }

}
