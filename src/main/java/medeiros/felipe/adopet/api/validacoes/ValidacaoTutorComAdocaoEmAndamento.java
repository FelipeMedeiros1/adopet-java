package medeiros.felipe.adopet.api.validacoes;

import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.Adocao;
import medeiros.felipe.adopet.api.model.StatusAdocao;
import medeiros.felipe.adopet.api.model.Tutor;
import medeiros.felipe.adopet.api.repository.AdocaoRepository;
import medeiros.felipe.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;
    @Autowired
    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoExcepetion("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}

