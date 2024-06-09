package br.com.ramengo.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ramengo.api.shared.RamenDTO;

@Repository
public class RamenRepository {

    List<RamenDTO> ramens = ramenList();

    public Optional<RamenDTO> getOneRamenByProteinName(String proteinName) {
        return ramens.stream()
        .filter(ramen -> ramen.getName() == proteinName)
        .findFirst();
    }
    

    public List<RamenDTO> ramenList(){

        List<RamenDTO> ramens = new ArrayList<>();

        // Ramen1
        RamenDTO ramen1 = new RamenDTO();
        ramen1.setId(1);
        ramen1.setName("Chasu");
        ramen1.setImage("https://tech.redventures.com.br/icons/ramen/ramenChasu.png");

        // Ramen2
        RamenDTO ramen2 = new RamenDTO();
        ramen2.setId(2);
        ramen2.setName("Yasai Vegetarian");
        ramen2.setImage("https://tech.redventures.com.br/icons/ramen/ramenKaraague.png");

        // Ramen3
        RamenDTO ramen3 = new RamenDTO();
        ramen3.setId(3);
        ramen3.setName("Karaague");
        ramen3.setImage("https://tech.redventures.com.br/icons/ramen/ramenKaraague.png");

        ramens.add(ramen1);
        ramens.add(ramen2);
        ramens.add(ramen3);

        return ramens;
    }

}
