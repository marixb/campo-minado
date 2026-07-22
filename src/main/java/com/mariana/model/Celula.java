package com.mariana.model;

public class Celula {
    private boolean TemMina;
    private boolean MinaRevelada;
    private boolean MinaMarcada;
    private int MinasVizinhas;
    
    public boolean isTemMina(){
        return TemMina;
    }

    public void setTemMina(boolean TemMina){
        this.TemMina = TemMina;

    }

    public boolean isMinaRevelada(){
        return MinaRevelada;
    }

    public void setMinaRevelada(boolean MinaRevelada){
        this.MinaRevelada = MinaRevelada;
    }

    public boolean isMinaMarcada(){
        return MinaMarcada;
    }

    public void alternarMarcacao(){
        this.MinaMarcada = !this.MinaMarcada;
    }

    public int getMinasVizinhas(){
        return MinasVizinhas;
    }

    public void SetMinasVizinhas(int MinasVizinhas){
        this.MinasVizinhas = MinasVizinhas;
    }
}
