package br.com.ramengo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramengo.api.repository.ProteinRepository;
import br.com.ramengo.api.shared.ProteinDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProteinService {

    @Autowired
    ProteinRepository proteinRepository;

    public List<ProteinDTO> getAll(){
        
        // try{

            log.info("Obtendo todas as proteinas");
            
            List<ProteinDTO> proteinsList = proteinRepository.findAll();

            log.info("Sucesso ao obter todas as proteinas!");
            
            return proteinsList;

        // } catch(Exception e){

        //     throw new UnsupportedOperationException("Erro ao obter todas as proteinas!" + e);
        // }

    }

    public Optional<ProteinDTO> getOne(Integer proteinId) {
        
        log.info("Obtendo proteina com ID " + proteinId);

        Optional<ProteinDTO> proteinDTO = proteinRepository.getOne(proteinId);
        
        // if (proteinDTO.isEmpty()) {
        //     throw new ResourceNotFoundException("Proteina com ID " + proteinId + " não encontrado!");
        // }
        
        log.info("Sucesso ao obter proteina com ID " + proteinId);

        return proteinDTO;
    }
    
}
