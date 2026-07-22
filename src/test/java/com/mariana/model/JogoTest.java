package com.mariana.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {
    @Test
    void DeveComecarEmAndamento(){
        Jogo jogo = new Jogo (5,5,3);
        assertEquals(EstadoJogo.EM_ANDAMENTO, jogo.getEstado());
    }

    @Test
    void DeveEntrarDerrotaClicandoEmMina(){
        Jogo jogo = new Jogo(3,3,0);
        jogo.getTabuleiro().colocarMina(1, 1);
        jogo.jogar(1,1);
        assertEquals(EstadoJogo.DERROTA, jogo.getEstado());
    }

    @Test
    void NaoDeveJogarPosDerrota(){
        Jogo jogo = new Jogo(3,3,0);
        jogo.getTabuleiro().colocarMina(1, 1);
        jogo.jogar(1,1);
        jogo.jogar(0,0);
        assertEquals(EstadoJogo.DERROTA, jogo.getEstado());

    }
    
    @Test
    void deveVencerComTodasCelulasSemMinasReveladas(){
        Jogo jogo = new Jogo(2,2,0);
        jogo.jogar(0,0);
        assertEquals(EstadoJogo.VITORIA, jogo.getEstado());
    }

    @Test
    void NaoDeveRevelarCelulaMarcada(){
        Jogo jogo = new Jogo(3,3,0);
        jogo.MarcarCelula(0, 0);
        jogo.jogar(0,0);
        assertFalse(jogo.getTabuleiro().getCelula(0, 0).isMinaRevelada());
    }
}
