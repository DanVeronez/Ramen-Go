package br.com.ramengo.api.view.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ramengo.api.service.OrderService;
import br.com.ramengo.api.view.model.OrderRequest;
import br.com.ramengo.api.view.model.OrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping()
    public ResponseEntity<OrderResponse> orderGeneretor(@RequestBody OrderRequest orderRequest) {

        OrderResponse orderResponse = orderService.orderGeneretor(orderRequest);

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

        return new ResponseEntity<>(orderResponse,HttpStatus.CREATED);
    }

}
