package br.com.ramengo.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ramengo.api.shared.ProteinDTO;

@Repository
public class ProteinRepository {
    
    // Simula chamado ao Banco
    List<ProteinDTO> proteins = proteinsList();

    public List<ProteinDTO> findAll() {
        return proteins;
    }

    public Optional<ProteinDTO> getOne(Integer proteinId) {

        return proteins.stream()
        .filter(protein -> protein.getId() == proteinId)
        .findFirst();

    }

    // Apenas para simular um banco de dados com proteinas pré cadastradas.
    public List<ProteinDTO> proteinsList() {

        List<ProteinDTO> proteinsList = new ArrayList<>();

        // Protein 1
        ProteinDTO protein1 = new ProteinDTO();
        protein1.setId(1);
        protein1.setImageInactive("https://tech.redventures.com.br/icons/pork/inactive.svg");
        protein1.setImageActive("https://tech.redventures.com.br/icons/pork/active.svg");
        protein1.setName("Chasu");
        protein1.setDescription("A sliced flavourful pork meat with a selection of season vegetables.");
        protein1.setPrice(10.0);

        // Protein 2
        ProteinDTO protein2 = new ProteinDTO();
        protein2.setId(2);
        protein2.setImageInactive("https://tech.redventures.com.br/icons/yasai/inactive.svg");
        protein2.setImageActive("https://tech.redventures.com.br/icons/yasai/active.svg");
        protein2.setName("Yasai Vegetarian");
        protein2.setDescription("A delicious vegetarian lamen with a selection of season vegetables.");
        protein2.setPrice(10.0);

        // Protein 3
        ProteinDTO protein3 = new ProteinDTO();
        protein3.setId(3);
        protein3.setImageInactive("https://tech.redventures.com.br/icons/chicken/inactive.svg");
        protein3.setImageActive("https://tech.redventures.com.br/icons/chicken/active.svg");
        protein3.setName("Karaague");
        protein3.setDescription("Three units of fried chicken, moyashi, ajitama egg and other vegetables.");
        protein3.setPrice(12.0);

        proteinsList.add(protein1);
        proteinsList.add(protein2);
        proteinsList.add(protein3);

        return proteinsList;
    }

}
