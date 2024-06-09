package br.com.ramengo.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ramengo.api.shared.BrothDTO;

@Repository
public class BrothRepository {

    List<BrothDTO> broths = brothsList();

    public List<BrothDTO> findAll() {
        return broths;
    }

    public Optional<BrothDTO> getOne(Integer brothId) {
        
        return broths.stream()
        .filter(broth -> broth.getId() == brothId)
        .findFirst();
    }

    // Apenas para simular um banco de dados.
    public List<BrothDTO> brothsList() {

        List<BrothDTO> brothsList = new ArrayList<>();

        // Caldo 1
        BrothDTO broth1 = new BrothDTO();
        broth1.setId(1);
        broth1.setImageInactive("https://tech.redventures.com.br/icons/salt/inactive.svg");
        broth1.setImageActive("https://tech.redventures.com.br/icons/salt/active.svg");
        broth1.setName("Salt");
        broth1.setDescription("Simple like the seawater, nothing more");
        broth1.setPrice(10.0);
    
        // Caldo 2
        BrothDTO broth2 = new BrothDTO();
        broth2.setId(2);
        broth2.setImageInactive("https://tech.redventures.com.br/icons/shoyu/inactive.svg");
        broth2.setImageActive("https://tech.redventures.com.br/icons/shoyu/active.svg");
        broth2.setName("Shoyu");
        broth2.setDescription("The good old and traditional soy sauce");
        broth2.setPrice(10.0);
    
        // Caldo 3
        BrothDTO broth3 = new BrothDTO();
        broth3.setId(3);
        broth3.setImageInactive("https://tech.redventures.com.br/icons/miso/inactive.svg");
        broth3.setImageActive("https://tech.redventures.com.br/icons/miso/active.svg");
        broth3.setName("Miso");
        broth3.setDescription("Paste made of fermented soybeans");
        broth3.setPrice(12.0);

        brothsList.add(broth1);
        brothsList.add(broth2);
        brothsList.add(broth3);

        return brothsList;
    }

}
