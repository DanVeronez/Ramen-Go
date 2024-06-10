package br.com.ramengo.api.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ramengo.api.model.error.ErrorMessage;
import br.com.ramengo.api.model.exception.InternalErrorServerExcepiton;
import br.com.ramengo.api.model.exception.MissingApiKeyExcepiton;
import br.com.ramengo.api.model.exception.MissingBodyRequestException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MissingBodyRequestException.class)
    public ResponseEntity<?> HandlerMissingBodyRequestException(MissingBodyRequestException ex){
    
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InternalErrorServerExcepiton.class)
    public ResponseEntity<?> HandlerInternalErrorServerExcepiton(InternalErrorServerExcepiton ex){
        
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(MissingApiKeyExcepiton.class)
    public ResponseEntity<?> MissingApiKeyExcepiton(MissingApiKeyExcepiton ex){
        
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        
        return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
    }

}
