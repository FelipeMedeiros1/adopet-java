package medeiros.felipe.adopet.api.controller;


import jakarta.validation.Valid;
import medeiros.felipe.adopet.api.dto.AtualizacaoTutorDto;
import medeiros.felipe.adopet.api.dto.CadastroTutorDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroTutorDto dto) {
        try {
            service.cadastrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoExcepetion exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizacaoTutorDto dto) {
        try {
            service.atualizar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoExcepetion exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
