package com.gerenciamento;

import java.io.Serializable;
import java.util.Date;

public class Progresso implements Serializable{
    private Object objetivo;
    private Date data;
    private String descricao;

    public Progresso(Object objetivo, Date data, String descricao){
        this.objetivo = objetivo;
        this.data = data;
        this.descricao = descricao;
    }

    public Object getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(Object objetivo) {
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
}
