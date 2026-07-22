package com.mariana.model;

public class Jogo {
    private final Tabuleiro tabuleiro;
    private EstadoJogo estado;

    public Jogo(int linhas, int colunas, int QuantidadeMinas){
        this.tabuleiro = new Tabuleiro(linhas, colunas, QuantidadeMinas);
        this.estado = EstadoJogo.EM_ANDAMENTO;
    }

    public void jogar(int linha, int coluna){
        if (estado != EstadoJogo.EM_ANDAMENTO){
            return;
        }
        Celula celula = tabuleiro.getCelula(linha, coluna);
        if(celula.isMinaMarcada()){
            return;
        }

        if (celula.isTemMina()){
            celula.setMinaRevelada(true);
            estado = EstadoJogo.DERROTA;
            return;
        }

        tabuleiro.RevelarCelula((linha), coluna);

        if (tabuleiro.TodasCelulasSemMinaRevelada()){
            estado = EstadoJogo.VITORIA;
        }
    }

    public void MarcarCelula(int linha, int coluna){
        if (estado != EstadoJogo.EM_ANDAMENTO){
            return;
        }
        tabuleiro.getCelula(linha, coluna).alternarMarcacao();
    }

    public EstadoJogo getEstado(){
        return estado;
    }

    public Tabuleiro getTabuleiro(){
        return tabuleiro;
    }
    
}
