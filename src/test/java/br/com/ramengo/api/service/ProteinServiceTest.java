package br.com.ramengo.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ramengo.api.repository.ProteinRepository;
import br.com.ramengo.api.shared.BrothDTO;
import br.com.ramengo.api.shared.ProteinDTO;

@ExtendWith(MockitoExtension.class)
public class ProteinServiceTest {

    @Mock
    private ProteinRepository proteinRepository;

    @InjectMocks
    private ProteinService proteinService;

    @Nested
    public class GetAllTest {
    
        @Test
        @DisplayName("Should return all proteins with success")
        void ShouldGetAllProteins() {
    
            // Arrange
            ProteinDTO protein1 = new ProteinDTO();
            protein1.setId(1);
            protein1.setImageInactive("https://tech.redventures.com.br/icons/pork/inactive.svg");
            protein1.setImageActive("https://tech.redventures.com.br/icons/pork/active.svg");
            protein1.setName("Chasu");
            protein1.setDescription("A sliced flavourful pork meat with a selection of season vegetables.");
            protein1.setPrice(10.0);
    
            List<ProteinDTO> proteinsList = List.of(protein1);

            doReturn(proteinsList)
                .when(proteinRepository).findAll();

            // Act
            List<ProteinDTO> output = proteinService.getAll();
    
            // Assert
            assertNotNull(output);
            assertEquals(proteinsList.size(), output.size());
        }
    }
    
}
