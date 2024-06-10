package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.model.exception.InternalErrorServerExcepiton;
import br.com.ramengo.api.model.exception.MissingApiKeyExcepiton;
import br.com.ramengo.api.service.AuthorizationService;
import br.com.ramengo.api.service.BrothService;
import br.com.ramengo.api.shared.BrothDTO;

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
@RequestMapping("/broths")
public class BrothController {

    @Autowired
    private BrothService brothService;

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping()
    public ResponseEntity<List<BrothDTO>> getAll(@RequestHeader(name = "X-API-KEY", required=true) String apikey){


        if(apikey.isBlank() || apikey.isEmpty()){
            throw new MissingApiKeyExcepiton("x-api-key header missing");
        }

        if(authorizationService.validate(apikey)){

            try{
                List<BrothDTO> broths = brothService.getAll();
                return new ResponseEntity<>(broths, HttpStatus.OK);
            }catch(Exception e){
                throw new InternalErrorServerExcepiton("could not find broths");
            }

        }else{
            throw new MissingApiKeyExcepiton("x-api-key not Autorized");
        }


    }

}
