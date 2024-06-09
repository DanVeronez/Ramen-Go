package br.com.ramengo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Parser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.ramengo.api.repository.RamenRepository;
import br.com.ramengo.api.shared.BrothDTO;
import br.com.ramengo.api.shared.ProteinDTO;
import br.com.ramengo.api.shared.RamenDTO;
import br.com.ramengo.api.view.model.OrderRequest;
import br.com.ramengo.api.view.model.OrderResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private RamenRepository ramenRepository;

    @Autowired
    private BrothService brothService;

    @Autowired
    private ProteinService proteinService;

    public OrderResponse orderGeneretor(OrderRequest orderRequest){

        OrderResponse orderResponse = new OrderResponse();

        // Fazer post pra gerar um ID
        String orderId = generateOrderID();

        // Adicionar a variavel id
        orderResponse.setId(Integer.parseInt(orderId));

        // Receber o os ids da proteina e caldo
        // Buscar os nomes da proteina e do caldo
        Optional<ProteinDTO> protein = proteinService.getOne(orderRequest.getProteinId());

        Optional<BrothDTO> broth = brothService.getOne(orderRequest.getBrothId());

        // Juntar os dois nomes e adicionar a variavel descrição
        orderResponse.setDescription(broth.get().getName() + " and " + protein.get().getName() + " Ramen");

        // buscar a imagem da combinação(nome da proteina) do prato no banco e retornar na varial image.
        Optional<RamenDTO> ramen = ramenRepository.getOneRamenByProteinName(protein.get().getName());

        orderResponse.setImage(ramen.get().getImage());
        // popular orderResponse e retornar



        return orderResponse;
    }

    public String generateOrderID(){

        // TODO: Colocar em properties
        String url = "https://api.tech.redventures.com.br/orders/generate-id";
        String apiKey = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";
    
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", apiKey);
        headers.set("Accept", "application/json");
    
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, requestEntity, Map.class);
        // TODO: MAP sem parametros

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, String> responseBody = response.getBody();

            log.info("Sucesso ao gerar numero do pedido. OrderId: " + responseBody.get("orderId"));

            return responseBody.get("orderId");
            // TODO: Retorno posde ser null ajustar nova exception
        } else {
            throw new RuntimeException("Falha ao gerar ID de pedido: " + response.getStatusCode());
        }

    }

}
