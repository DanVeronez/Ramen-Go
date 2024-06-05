package br.com.ramengo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramengo.api.repository.ProteinRepository;
import br.com.ramengo.api.shared.ProteinDTO;

@Service
public class ProteinService {

    @Autowired
    ProteinRepository proteinRepository;

    public List<ProteinDTO> getAll(){
        
        List<ProteinDTO> proteinsList = proteinRepository.findAll();

        return proteinsList;
    }
    
}
