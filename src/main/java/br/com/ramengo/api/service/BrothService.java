package br.com.ramengo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramengo.api.repository.BrothRepository;
import br.com.ramengo.api.shared.BrothDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BrothService {

    @Autowired
    private BrothRepository brothRepository;

    public List<BrothDTO> getAll() {

        List<BrothDTO> broths = brothRepository.findAll();

        return broths;
    }

    public Optional<BrothDTO> getOne(Integer brothId) {
        
        log.info("Obtendo caldo com ID " + brothId);

        Optional<BrothDTO> brothDTO = brothRepository.getOne(brothId);
        
        // if (brothDTO.isEmpty()) {
        //     throw new ResourceNotFoundException("Caldo com ID " + brothId + " não encontrado!");
        // }
        
        log.info("Sucesso ao obter proteina com ID " + brothId);

        return brothDTO;
    }

}
