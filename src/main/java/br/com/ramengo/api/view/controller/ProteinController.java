package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.model.exception.InternalErrorServerExcepiton;
import br.com.ramengo.api.model.exception.MissingApiKeyExcepiton;
import br.com.ramengo.api.service.AuthorizationService;
import br.com.ramengo.api.service.ProteinService;
import br.com.ramengo.api.shared.ProteinDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "/**")
@RequestMapping("/proteins")
public class ProteinController {
    
    @Autowired
    private ProteinService proteinService;

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping()
    public ResponseEntity<List<ProteinDTO>> getAll(@RequestHeader(name = "X-API-KEY", required=true) String apikey) {

        if(apikey.isBlank() || apikey.isEmpty()){
            throw new MissingApiKeyExcepiton("x-api-key header missing");
        }

        if(authorizationService.validate(apikey)){

            try{
                List<ProteinDTO> proteinsList = proteinService.getAll();
                return new ResponseEntity<>(proteinsList, HttpStatus.OK);
            }catch(Exception e){
                throw new InternalErrorServerExcepiton("could not find broths");
            }

        }else{
            throw new MissingApiKeyExcepiton("x-api-key not Autorized");
        }


    }
    
}
