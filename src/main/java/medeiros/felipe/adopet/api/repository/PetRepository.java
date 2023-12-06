package medeiros.felipe.adopet.api.repository;

import medeiros.felipe.adopet.api.model.Abrigo;
import medeiros.felipe.adopet.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

        List<Pet> findAllByAdotadoFalse();

        List<Pet> findByAbrigo(Abrigo abrigo);
    }
