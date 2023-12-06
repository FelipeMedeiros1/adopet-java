package medeiros.felipe.adopet.api.service;


import medeiros.felipe.adopet.api.dto.CadastroPetDto;
import medeiros.felipe.adopet.api.dto.PetDto;
import medeiros.felipe.adopet.api.model.Abrigo;
import medeiros.felipe.adopet.api.model.Pet;
import medeiros.felipe.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDto> buscarPetsDisponiveis() {
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDto::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
