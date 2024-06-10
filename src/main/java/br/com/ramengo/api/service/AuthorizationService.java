package br.com.ramengo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramengo.api.model.AuthorizationApiKey;



@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationApiKey authorizationApiKey;
    
    public boolean validate(String apikey) {

        if(apikey.equals(authorizationApiKey.getApikey()) ){
            return true;
        }else{
            return false;
        }

    }

}
