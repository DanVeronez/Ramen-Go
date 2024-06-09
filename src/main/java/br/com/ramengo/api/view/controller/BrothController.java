package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.service.BrothService;
import br.com.ramengo.api.shared.BrothDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/broths")
public class BrothController {

    @Autowired
    private BrothService brothService;

    @GetMapping()
    public ResponseEntity<List<BrothDTO>> getAll(){

        List<BrothDTO> broths = brothService.getAll();

        return new ResponseEntity<>(broths, HttpStatus.OK);
    }

}
