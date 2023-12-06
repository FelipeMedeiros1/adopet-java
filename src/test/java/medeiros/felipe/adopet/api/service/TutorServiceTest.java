package medeiros.felipe.adopet.api.service;


import medeiros.felipe.adopet.api.dto.AtualizacaoTutorDto;
import medeiros.felipe.adopet.api.dto.CadastroTutorDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.Tutor;
import medeiros.felipe.adopet.api.repository.TutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TutorServiceTest {

    @InjectMocks
    private TutorService service;

    @Mock
    private TutorRepository repository;

    @Mock
    private CadastroTutorDto dto;

    @Mock
    private Tutor tutor;

    @Mock
    private AtualizacaoTutorDto atualizacaoTutorDto;

    @Test
    void NaoDeveriaCadastrarTutorTelefoneOuEmailJaCadastrado() {
        //Arrange + Act
        given(repository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(true);

        //Assert
        assertThrows(ValidacaoExcepetion.class, () -> service.cadastrar(dto));
    }

    @Test
    void deveriaCadastrarTutor() {
        //Arrange
        given(repository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(false);

        //Act + Assert
        assertDoesNotThrow(() -> service.cadastrar(dto));
        then(repository).should().save(new Tutor(dto));
    }

    @Test
    void deveriaAtualizarDadosTutor() {
        //Arrange
        given(repository.getReferenceById(atualizacaoTutorDto.id())).willReturn(tutor);

        //Act
        service.atualizar(atualizacaoTutorDto);

        //Assert
        then(tutor).should().atualizarDados(atualizacaoTutorDto);
    }

}