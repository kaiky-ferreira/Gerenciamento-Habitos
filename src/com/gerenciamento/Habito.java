package com.gerenciamento;

import java.io.Serializable;

public class Habito implements Serializable{
    private String nome;
    private String descricao;
    private String frequencia;

    public Habito(String nome, String descricao, String frequencia){
        this.nome = nome;
        this.descricao = descricao;
        this.frequencia = frequencia;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getFrequencia(){
        return this.frequencia;
    }
    public void setFrequencia(String frequencia){
        this.frequencia = frequencia;
    }
}
