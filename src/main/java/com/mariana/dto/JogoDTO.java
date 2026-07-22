package com.mariana.dto;

public class JogoDTO {
    private String estado;
    private CelulaDTO[][] celulas;

    public JogoDTO(String estado, CelulaDTO[][] celulas) {
        this.estado = estado;
        this.celulas = celulas;
    }

    public String getEstado() {
        return estado;
    }

    public CelulaDTO[][] getCelulas() {
        return celulas;
    }
}