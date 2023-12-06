package medeiros.felipe.adopet.api.validacoes;


import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.StatusAdocao;
import medeiros.felipe.adopet.api.repository.AdocaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComLimiteDeAdocoesTest {
    @InjectMocks
    private ValidacaoTutorComLimiteDeAdocoes validador;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;


    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoTutorAtingiuLimiteDe5Adocoes() {
        //Arrange
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(5);

        //Act + Assert
        assertThrows(ValidacaoExcepetion.class,() ->validador.validar(dto));
    }

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoTutorNaoAtingiuLimiteDe5Adocoes() {
        //Arrange
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(),StatusAdocao.APROVADO)).willReturn(4);

        //Act + Assert
        assertDoesNotThrow(() -> validador.validar(dto));
    }

}