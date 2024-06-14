package com.gerenciamento;

import java.io.Serializable;
import java.util.Date;

public class Progresso implements Serializable {
    private Habito objetivo;
    private Date data;
    private String descricao;

    public Progresso(Habito objetivo, Date data, String descricao) {
        this.objetivo = objetivo;
        this.data = data;
        this.descricao = descricao;
    }

    public Habito getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Habito objetivo) {
        this.objetivo = objetivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Progresso{" +
                "objetivo=" + objetivo +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
