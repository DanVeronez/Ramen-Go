package br.com.ramengo.api.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationApiKey {

    @Value("${api.key}")
    private String apikey;

    public String getApikey() {
        return apikey;
    }
    
}
