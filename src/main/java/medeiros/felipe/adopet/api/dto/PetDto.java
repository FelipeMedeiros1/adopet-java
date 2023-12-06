package medeiros.felipe.adopet.api.dto;

import medeiros.felipe.adopet.api.model.Pet;
import medeiros.felipe.adopet.api.model.TipoPet;

public record PetDto(Long id, TipoPet tipo, String nome, String raca, Integer idade) {

    public PetDto(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}
