package medeiros.felipe.adopet.api.service;

import medeiros.felipe.adopet.api.dto.AtualizacaoTutorDto;
import medeiros.felipe.adopet.api.dto.CadastroTutorDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.Tutor;
import medeiros.felipe.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDto dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoExcepetion("Dados já cadastrados para outro tutor!");
        }

        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }

}
