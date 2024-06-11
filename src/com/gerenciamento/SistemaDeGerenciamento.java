package com.gerenciamento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeGerenciamento {
    private List<Meta> metas;
    private List<Habito> habitos;
    private List<Progresso> progressos;

    public SistemaDeGerenciamento() {
        this.metas = new ArrayList<>();
        this.habitos = new ArrayList<>();
        this.progressos = new ArrayList<>();
    }

    public void cadastrarMeta(Meta meta) {
        metas.add(meta);
    }

    public void cadastrarHabito(Habito habito) {
        habitos.add(habito);
    }

    public void adicionarProgresso(Progresso progresso) {
        progressos.add(progresso);
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public List<Habito> getHabitos() {
        return habitos;
    }

    public List<Progresso> getProgressos() {
        return progressos;
    }



    // Métodos para salvar e carregar os dados em arquivos
    public void salvarDados() {
        try {
            FileOutputStream fileOut = new FileOutputStream("sistema.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(metas);
            out.writeObject(habitos);
            out.writeObject(progressos);
            out.close();
            fileOut.close();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException i) {
            System.out.println("Erro ao salvar dados: " + i.getMessage());
        }
    }

    public void carregarDados() {
        try {
            FileInputStream fileIn = new FileInputStream("sistema.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            metas = (List<Meta>) in.readObject();
            habitos = (List<Habito>) in.readObject();
            progressos = (List<Progresso>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("Nenhum dado encontrado ou erro ao carregar dados: " + i.getMessage());
        }
    }
}
