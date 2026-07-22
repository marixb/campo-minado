package com.mariana.controller;

import com.mariana.dto.CelulaDTO;
import com.mariana.dto.JogoDTO;
import com.mariana.model.Celula;
import com.mariana.model.EstadoJogo;
import com.mariana.model.Jogo;
import com.mariana.model.Tabuleiro;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @PostMapping("/novo")
    public JogoDTO novoJogo(HttpSession session,
                             @RequestParam(defaultValue = "8") int linhas,
                             @RequestParam(defaultValue = "8") int colunas,
                             @RequestParam(defaultValue = "10") int minas) {
        Jogo jogo = new Jogo(linhas, colunas, minas);
        session.setAttribute("jogo", jogo);
        return montarDTO(jogo);
    }

    @PostMapping("/jogar")
    public JogoDTO jogar(HttpSession session,
                          @RequestParam int linha,
                          @RequestParam int coluna) {
        Jogo jogo = obterJogo(session);
        jogo.jogar(linha, coluna);
        return montarDTO(jogo);
    }

    @PostMapping("/marcar")
    public JogoDTO marcar(HttpSession session,
                           @RequestParam int linha,
                           @RequestParam int coluna) {
        Jogo jogo = obterJogo(session);
        jogo.MarcarCelula(linha, coluna);
        return montarDTO(jogo);
    }

    @GetMapping("/estado")
    public JogoDTO estado(HttpSession session) {
        Jogo jogo = obterJogo(session);
        return montarDTO(jogo);
    }

    private Jogo obterJogo(HttpSession session) {
        Jogo jogo = (Jogo) session.getAttribute("jogo");
        if (jogo == null) {
            throw new IllegalStateException("Nenhum jogo em andamento. Crie um novo jogo primeiro.");
        }
        return jogo;
    }

    private JogoDTO montarDTO(Jogo jogo) {
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        boolean jogoAcabou = jogo.getEstado() != EstadoJogo.EM_ANDAMENTO;

        CelulaDTO[][] celulasDTO = new CelulaDTO[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                Celula celula = tabuleiro.getCelula(i, j);
                boolean mostrarMina = celula.isTemMina() && (celula.isMinaRevelada() || jogoAcabou);

                celulasDTO[i][j] = new CelulaDTO(
                        celula.isMinaRevelada(),
                        celula.isMinaMarcada(),
                        mostrarMina,
                        celula.getMinasVizinhas()
                );
            }
        }

        return new JogoDTO(jogo.getEstado().name(), celulasDTO);
    }
}