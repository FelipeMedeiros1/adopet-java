package medeiros.felipe.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import medeiros.felipe.adopet.api.model.TipoPet;

public record CadastroPetDto(
        @NotNull
        TipoPet tipo,
        @NotBlank
        String nome,
        @NotBlank
        String raca,
        @NotNull
        Integer idade,
        @NotBlank
        String cor,
        @NotNull
        Float peso) {
}
