package br.com.ramengo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramengo.api.repository.BrothRepository;
import br.com.ramengo.api.shared.BrothDTO;

@Service
public class BrothService {

    @Autowired
    private BrothRepository brothRepository;

    public List<BrothDTO> getAll() {

        List<BrothDTO> brothsDTO = brothRepository.findAll();

        return brothsDTO;
    }

}
