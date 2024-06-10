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

import br.com.ramengo.api.repository.BrothRepository;
import br.com.ramengo.api.shared.BrothDTO;

@ExtendWith(MockitoExtension.class)
public class BrothServiceTest {

    @Mock
    private BrothRepository brothRepository;

    @InjectMocks
    private BrothService brothService;

    @Nested
    public class GetAllTest {
    
        @Test
        @DisplayName("Should return all broths with success")
        void ShouldGetAllBroths() {
    
            // Arrange
            BrothDTO broth1 = new BrothDTO();
            broth1.setId(1);
            broth1.setImageInactive("https://tech.redventures.com.br/icons/salt/inactive.svg");
            broth1.setImageActive("https://tech.redventures.com.br/icons/salt/active.svg");
            broth1.setName("Salt");
            broth1.setDescription("Simple like the seawater, nothing more");
            broth1.setPrice(10.0);
    
            List<BrothDTO> brothsList = List.of(broth1);

            doReturn(brothsList)
                .when(brothRepository).findAll();

            // Act
            List<BrothDTO> output = brothService.getAll();
    
            // Assert
            assertNotNull(output);
            assertEquals(brothsList.size(), output.size());
        }
    }

}
