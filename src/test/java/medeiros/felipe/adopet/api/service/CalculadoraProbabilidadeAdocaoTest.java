package medeiros.felipe.adopet.api.service;


import medeiros.felipe.adopet.api.dto.CadastroAbrigoDto;
import medeiros.felipe.adopet.api.dto.CadastroPetDto;
import medeiros.felipe.adopet.api.model.Abrigo;
import medeiros.felipe.adopet.api.model.Pet;
import medeiros.felipe.adopet.api.model.ProbabilidadeAdocao;
import medeiros.felipe.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraProbabilidadeAdocaoTest {

    @Test
    void deveriaRetornarProbabilidadeAltaParaPetComIdadeBaixaEPesoBaixo(){
        //idade 4 anos e 4kg - ALTA

        //ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "Siames",
                4,
                "Cinza",
                4.0f
        ), abrigo);
        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();

        //ACT
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        //ASSERT
        Assertions.assertEquals(ProbabilidadeAdocao.ALTA,probabilidade);
    }

    @Test
    void deveriaRetornarProbabilidadeMediaParaPetComIdadeAltaEPesoBaixo(){
        //idade 15 anos e 4kg - MEDIA

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "Siames",
                15,
                "Cinza",
                4.0f
        ), abrigo);
        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();


        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA,probabilidade);
    }



}