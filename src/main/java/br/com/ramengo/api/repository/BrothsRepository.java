package br.com.ramengo.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.ramengo.api.shared.BrothsDTO;

@Repository
public class BrothsRepository {

    public List<BrothsDTO> findAll() {

        List<BrothsDTO> brothsList = listOfBroths();

        return brothsList;

    }



    public List<BrothsDTO> listOfBroths() {

        // Instance 1
        BrothsDTO broth1 = new BrothsDTO();
        broth1.setId(1L);
        broth1.setImageInactive("broth_inactive_1.jpg");
        broth1.setImageActive("broth_active_1.jpg");
        broth1.setName("Caldo Verde");
        broth1.setDescription("Portuguese green broth with kale, sausage, and potatoes");
        broth1.setPrice(15.90);
    
        // Instance 2
        BrothsDTO broth2 = new BrothsDTO();
        broth2.setId(2L);
        broth2.setImageInactive("broth_inactive_2.jpg");
        broth2.setImageActive("broth_active_2.jpg");
        broth2.setName("Chicken Noodle Soup");
        broth2.setDescription("Classic chicken noodle soup with vegetables and pasta");
        broth2.setPrice(12.50);
    
        // Instance 3
        BrothsDTO broth3 = new BrothsDTO();
        broth3.setId(3L);
        broth3.setImageInactive("broth_inactive_3.jpg");
        broth3.setImageActive("broth_active_3.jpg");
        broth3.setName("Spicy Tomato Soup");
        broth3.setDescription("Hearty tomato soup with a spicy kick");
        broth3.setPrice(18.00);

        List<BrothsDTO> brothsList = new ArrayList<>();

        brothsList.add(broth1);
        brothsList.add(broth2);
        brothsList.add(broth3);

        return brothsList;
    }

}
