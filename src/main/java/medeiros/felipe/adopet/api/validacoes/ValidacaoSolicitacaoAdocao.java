package medeiros.felipe.adopet.api.validacoes;

import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {
    void validar(SolicitacaoAdocaoDto dto);
}
