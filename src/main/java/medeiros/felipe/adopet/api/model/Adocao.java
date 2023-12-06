package medeiros.felipe.adopet.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "adocoes")
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutor;

    @OneToOne(fetch = FetchType.LAZY)
    private Pet pet;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusAdocao status;

    private String justificativaStatusReprovado;

    public Adocao(Tutor tutor, Pet pet, String motivo) {
        this.tutor = tutor;
        this.pet = pet;
        this.motivo = motivo;
        this.status = StatusAdocao.AGUARDANDO_AVALIACAO;
        this.data = LocalDateTime.now();
    }
    public Adocao(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adocao adocao = (Adocao) o;
        return Objects.equals(id, adocao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public Tutor getTutor() {
        return tutor;
    }

    public Pet getPet() {
        return pet;
    }
    public String getMotivo() {return motivo;}
    public StatusAdocao getStatus() {
        return status;
    }
    public String getJustificativaStatusReprovado() {
        return justificativaStatusReprovado;
    }

    public void statusAprovado() {this.status = StatusAdocao.APROVADO;}
    public void statusReprovado(String justificativa) {
        this.status =StatusAdocao.REPROVADO;
        this.justificativaStatusReprovado = justificativa;
    }
}