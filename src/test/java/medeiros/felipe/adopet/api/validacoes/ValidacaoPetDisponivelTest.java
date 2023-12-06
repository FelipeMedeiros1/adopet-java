package medeiros.felipe.adopet.api.validacoes;

import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.Pet;
import medeiros.felipe.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ValidacaoPetDisponivelTest {

    @InjectMocks
    private ValidacaoPetDisponivel validacao;
    @Mock
    private PetRepository petRepository;

    @Mock
    private Pet pet;
    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet(){

        //ARRANGE
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(false);



        //ASSERT + ACT
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoPet(){

        //ARRANGE
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);



        //ASSERT + ACT
        Assertions.assertThrows(ValidacaoExcepetion.class,() -> validacao.validar(dto));
    }

}