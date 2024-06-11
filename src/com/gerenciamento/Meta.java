package com.gerenciamento;

import java.io.Serializable;
import java.util.Date;

public class Meta implements Serializable{
    private String nome, descricao, status;
    private Date dataInicio, dataFim;

    public Meta(String nome, String descricao, Date dataInicio, Date dataFim){
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = "não iniciado";
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

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Date getDataInicio(){
        return this.dataInicio;
    }
    public void setDataInicio(Date dataInicio){
        this.dataInicio = dataInicio;
    }

    public Date getDataFim(){
        return this.dataFim;
    }
    public void setDataFim(Date dataFim){
        this.dataFim = dataFim;
    }
}

