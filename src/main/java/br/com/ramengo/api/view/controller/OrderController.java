package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.model.exception.InternalErrorServerExcepiton;
import br.com.ramengo.api.model.exception.MissingApiKeyExcepiton;
import br.com.ramengo.api.model.exception.MissingBodyRequestException;
import br.com.ramengo.api.service.AuthorizationService;
import br.com.ramengo.api.service.OrderService;
import br.com.ramengo.api.view.model.OrderRequest;
import br.com.ramengo.api.view.model.OrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "/**")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthorizationService authorizationService;
    
    @PostMapping()
    public ResponseEntity<OrderResponse> orderGeneretor(@RequestBody OrderRequest orderRequest, @RequestHeader(name = "X-API-KEY", required=true) String apikey) {

        if (orderRequest.getBrothId() == null || orderRequest.getProteinId() == null) {
            throw new MissingBodyRequestException("both brothId and proteinId are required");
        }

        if(apikey.isBlank() || apikey.isEmpty()){
            throw new MissingApiKeyExcepiton("x-api-key header missing");
        }

        if(authorizationService.validate(apikey)){

            try{
                OrderResponse orderResponse = orderService.orderGeneretor(orderRequest);
                return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
            }catch(Exception e){
                throw new InternalErrorServerExcepiton("could not place order");
            }

        }else{
            throw new MissingApiKeyExcepiton("x-api-key not Autorized");
        }




        // TODO: Buscar pelos ids e retornar o nome do caldo/proteina
        // TODO: Criar findById do broth e protein
        // TODO: buscar imagem do remen (Verificar se há uma imagem para cada combinação de caldo e proteina ou retornar apenas a mesma imagem)
        // TODO: buscar gerar ID pela api IdGeneratorRV
        // TODO: juntar as duas descrições em uma nova descriçao
        // TODO: Adicionar todas esses dados ao objeto OrderResponse

        // TODO: Melhorar tranferencias dos dados entre as classes
        // TODO: Criar Response e Requeste se necessário nas outras classes
        // TODO: Criar testes unitários para cada resquest
        // TODO: criar validação dos dados
        // TODO: verificar se os tipos estão adequados.
        // TODO: Criar Logs

        // OrderResponse orderResponse = new OrderResponse();
        // orderResponse.setId(12345);
        // orderResponse.setDescription("Salt and Chasu Ramen");
        // orderResponse.setImage("https://tech.redventures.com.br/icons/ramen/ramenChasu.png");

        // TODO: Tratamento de excecoes
        // TODO: Testes unitários
        // TODO: LOGS
        // TODO: Tratar erro de CORS
        // TODO: Dockerizar aplicação
        // TODO: Subir na AWS


    }

}
