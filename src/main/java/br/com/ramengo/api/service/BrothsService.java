package br.com.ramengo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramengo.api.repository.BrothsRepository;
import br.com.ramengo.api.shared.BrothsDTO;

@Service
public class BrothsService {

    @Autowired
    private BrothsRepository brothsRepository;

    public List<BrothsDTO> getAll() {

        List<BrothsDTO> brothsDTO = brothsRepository.findAll();

        return brothsDTO;
    }

}
