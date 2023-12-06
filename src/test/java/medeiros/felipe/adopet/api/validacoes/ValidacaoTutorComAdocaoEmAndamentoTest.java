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
class ValidacaoTutorComAdocaoEmAndamentoTest {
    @InjectMocks
    private ValidacaoTutorComAdocaoEmAndamento validador;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoTutorComAdocaoEmAndamento() {
        //Arrange
        given(adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);

        //Act + Assert
        assertThrows(ValidacaoExcepetion.class, () -> validador.validar(dto));
    }

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoTutorSemAdocaoEmAndamento() {
        //Arrange
        given(adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(false);

        //Act + Assert
        assertDoesNotThrow(() -> validador.validar(dto));
    }

}