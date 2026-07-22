package com.mariana.dto;

public class CelulaDTO {
    private boolean revelada;
    private boolean marcada;
    private boolean mina;
    private int minasVizinhas;

    public CelulaDTO(boolean revelada, boolean marcada, boolean mina, int minasVizinhas) {
        this.revelada = revelada;
        this.marcada = marcada;
        this.mina = mina;
        this.minasVizinhas = minasVizinhas;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public boolean isMina() {
        return mina;
    }

    public int getMinasVizinhas() {
        return minasVizinhas;
    }
}