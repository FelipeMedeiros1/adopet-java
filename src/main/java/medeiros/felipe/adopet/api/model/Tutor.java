package medeiros.felipe.adopet.api.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import medeiros.felipe.adopet.api.dto.AtualizacaoTutorDto;
import medeiros.felipe.adopet.api.dto.CadastroTutorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tutores")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    @OneToMany(mappedBy = "tutor")
    private List<Adocao> adocoes = new ArrayList<>();

    public Tutor() {
    }

    public Tutor(CadastroTutorDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }

    public void atualizarDados(AtualizacaoTutorDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }
}