package medeiros.felipe.adopet.api.controller;

import jakarta.validation.Valid;
import medeiros.felipe.adopet.api.dto.AbrigoDto;
import medeiros.felipe.adopet.api.dto.CadastroAbrigoDto;
import medeiros.felipe.adopet.api.dto.CadastroPetDto;
import medeiros.felipe.adopet.api.dto.PetDto;
import medeiros.felipe.adopet.api.excpetion.ValidacaoExcepetion;
import medeiros.felipe.adopet.api.model.Abrigo;
import medeiros.felipe.adopet.api.service.AbrigoService;
import medeiros.felipe.adopet.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<AbrigoDto>> listar() {
        List<AbrigoDto> abrigos = abrigoService.listar();
        return ResponseEntity.ok(abrigos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroAbrigoDto dto) {
        try {
            abrigoService.cadatrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoExcepetion exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<PetDto>> listarPets(@PathVariable String idOuNome) {
        try {
            List<PetDto> petsDoAbrigo = abrigoService.listarPetsDoAbrigo(idOuNome);
            return ResponseEntity.ok(petsDoAbrigo);
        } catch (ValidacaoExcepetion exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idOuNome}/pets")
    @Transactional
    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid CadastroPetDto dto) {
        try {
            Abrigo abrigo = abrigoService.carregarAbrigo(idOuNome);
            petService.cadastrarPet(abrigo, dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoExcepetion exception) {
            return ResponseEntity.notFound().build();
        }
    }

}
