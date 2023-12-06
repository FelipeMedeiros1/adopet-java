package medeiros.felipe.adopet.api.dto;


import medeiros.felipe.adopet.api.model.Abrigo;

public record AbrigoDto(Long id, String nome) {

    public AbrigoDto(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
