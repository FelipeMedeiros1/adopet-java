package medeiros.felipe.adopet.api.validacoes;

import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.StatusAdocao;
import medeiros.felipe.adopet.api.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;


    public void validar(SolicitacaoAdocaoDto dto) {
        boolean petTemAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(dto.idPet(),StatusAdocao.AGUARDANDO_AVALIACAO );

        if (petTemAdocaoEmAndamento) {
            throw new ValidacaoExcepetion("Pet já está aguardando avaliação para ser adotado!");

        }
    }
}
