package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.service.BrothsService;
import br.com.ramengo.api.shared.BrothsDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/broths")
public class BrothsController {

    @Autowired
    private BrothsService brothsService;

    @GetMapping()
    public ResponseEntity<List<BrothsDTO>> getAll(){

        List<BrothsDTO> brothsDTO = brothsService.getAll();

        return new ResponseEntity<>(brothsDTO, HttpStatus.OK);
    }


    // @GetMapping
    // public ResponseEntity<List<BrothsResponse>> obterTodos(){

    //     List<BrothsDTO> produtosDTO = brothsService.obterTodos();

    //     List<BrothsResponse> produtoResponse = produtosDTO.stream()
    //     .map(produtoDTO -> new ModelMapper().map(produtoDTO, ProdutoResponse.class))
    //     .collect(Collectors.toList());

    //     return new ResponseEntity<>(BrothsResponse, HttpStatus.OK);
    // }

}
