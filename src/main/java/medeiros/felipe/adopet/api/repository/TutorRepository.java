package medeiros.felipe.adopet.api.repository;

import medeiros.felipe.adopet.api.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByTelefoneOrEmail(String telefone, String email);

}
