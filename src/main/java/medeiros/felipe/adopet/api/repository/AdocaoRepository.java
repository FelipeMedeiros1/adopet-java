package medeiros.felipe.adopet.api.repository;

import medeiros.felipe.adopet.api.model.Adocao;
import medeiros.felipe.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
    //criar método com padrão de nomenclatura para o spring fazer a consulta no banco

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    boolean existsByTutorIdAndStatus(Long idPet, StatusAdocao status);

    Integer countByTutorIdAndStatus(Long idTutor, StatusAdocao status);

}
