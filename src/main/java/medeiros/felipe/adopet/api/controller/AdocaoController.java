package medeiros.felipe.adopet.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import medeiros.felipe.adopet.api.dto.AprovacaoAdocaoDto;
import medeiros.felipe.adopet.api.dto.ReprovacaoAdocaoDto;
import medeiros.felipe.adopet.api.dto.SolicitacaoAdocaoDto;
import medeiros.felipe.adopet.api.service.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoAdocaoDto dto) {
        try {
            this.adocaoService.solicitar(dto);
            return ResponseEntity.ok("Adoção solciitada com sucesso!");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovacaoAdocaoDto dto) {
        this.adocaoService.aprovar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovacaoAdocaoDto dto) {
        this.adocaoService.reprovar(dto);
        return ResponseEntity.ok().build();
    }

}
