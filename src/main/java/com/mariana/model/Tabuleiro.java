package com.mariana.model;

import java.util.Random;

public class Tabuleiro {
    private final int linhas;
    private final int colunas;
    private final Celula[][] celulas;
    
    public Tabuleiro(int linhas, int colunas, int QuantidadeMinas){
        this.linhas = linhas;
        this.colunas = colunas;
        this.celulas = new Celula[linhas][colunas];

        InicializarCelulas();
        PosicionarMinas(QuantidadeMinas);
        CalcularMinasVizinhas();
    }

    private void InicializarCelulas(){
        for (int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                celulas[i][j] = new Celula();
            }
        }
    }

    private void PosicionarMinas(int QuantidadeMinas){
        Random random = new Random();
        int MinasColocadas = 0;

        while (MinasColocadas < QuantidadeMinas){
            int linha = random.nextInt(linhas);
            int coluna = random.nextInt(colunas);

            if (!celulas[linha][coluna].isTemMina()){
                celulas[linha][coluna].setTemMina(true);
                MinasColocadas++;
            }
        }
    }

    private void CalcularMinasVizinhas(){
        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                if (!celulas[i][j].isTemMina()){
                    celulas[i][j].SetMinasVizinhas(ContarMinasVizinhas(i, j));
                }
            }
        }
    }

    private int ContarMinasVizinhas(int linha, int coluna) {
        int contador = 0;

        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                if (i == linha && j == coluna) {
                    continue;
                }
                if (i >= 0 && i < linhas && j >= 0 && j < colunas) {
                    if (celulas[i][j].isTemMina()) {
                        contador++;
                    }
                }
            }
        }

        return contador;
    }

    public void RevelarCelula(int linha, int coluna){
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas){
            return;
        }
        Celula celula = celulas[linha][coluna];
        if (celula.isMinaRevelada() || celula.isMinaMarcada()){
            return;
        }
        celula.setMinaRevelada(true);

        if(!celula.isTemMina() && celula.getMinasVizinhas() == 0){
            for (int i = linha - 1; i <= linha + 1; i++){
                for (int j = coluna -1; j<= coluna +1; j++){
                    if (i == linha && j == coluna){
                        continue;
                    }
                    RevelarCelula (i,j);
                }
            }
        }
    }
    public boolean TodasCelulasSemMinaRevelada(){
        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas;j++){
                Celula celula = celulas[i][j];
                if (!celula.isTemMina() && !celula.isMinaRevelada()){
                    return false;
                }
            }
        }
        return true;
    }
    public void colocarMina(int linha, int coluna) {
    celulas[linha][coluna].setTemMina(true);
    CalcularMinasVizinhas();
    }

    public int contarMinasVizinhas(int linha, int coluna) {
    return ContarMinasVizinhas(linha, coluna);
    }
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Celula getCelula(int linha, int coluna) {
        return celulas[linha][coluna];
    }
}