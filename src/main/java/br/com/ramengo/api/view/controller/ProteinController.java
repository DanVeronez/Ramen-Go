package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.service.ProteinService;
import br.com.ramengo.api.shared.ProteinDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/proteins")
public class ProteinController {
    
    @Autowired
    private ProteinService proteinService;

    @GetMapping()
    public ResponseEntity<List<ProteinDTO>> getAll() {
        List<ProteinDTO> proteinsList = proteinService.getAll();
        return new ResponseEntity<>(proteinsList, HttpStatus.OK);
    }
    
}
