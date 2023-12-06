package medeiros.felipe.adopet.api.validacoes;

import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.Pet;
import medeiros.felipe.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao{

    @Autowired
    private PetRepository petRepository;
    public void validar(SolicitacaoAdocaoDto dto){
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoExcepetion("Pet já foi adotado!");
        }
    }
}
