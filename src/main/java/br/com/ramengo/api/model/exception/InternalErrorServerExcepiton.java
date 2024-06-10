package br.com.ramengo.api.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorServerExcepiton extends RuntimeException{
    
    public InternalErrorServerExcepiton(String message){
        super(message);
    }


}
