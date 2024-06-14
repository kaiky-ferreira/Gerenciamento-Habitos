package com.gerenciamento;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaDeGerenciamento {
    private List<Habito> habitos;
    private List<Progresso> progressos;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public SistemaDeGerenciamento() {
        this.habitos = new ArrayList<>();
        this.progressos = new ArrayList<>();
    }

    public void cadastrarHabito(Scanner scanner) {
        System.out.print("Nome do Hábito: ");
        String nomeHabito = scanner.nextLine();
        System.out.print("Descrição do Hábito: ");
        String descricaoHabito = scanner.nextLine();
        System.out.print("Frequência do Hábito: ");
        String frequenciaHabito = scanner.nextLine();

        Habito habito = new Habito(nomeHabito, descricaoHabito, frequenciaHabito);
        habitos.add(habito);
        System.out.println("Hábito cadastrado com sucesso!");
    }

    public void registrarProgresso(Scanner scanner) {
        System.out.print("Nome do Hábito: ");
        String nomeHabito = scanner.nextLine();
        Habito habito = encontrarHabito(nomeHabito);

        if (habito != null) {
            System.out.print("Data do Progresso (dd-MM-yyyy): ");
            String dataProgresso = scanner.nextLine();
            System.out.print("Descrição do Progresso: ");
            String descricaoProgresso = scanner.nextLine();

            try {
                Date data = dateFormat.parse(dataProgresso);
                Progresso progresso = new Progresso(habito, data, descricaoProgresso);
                progressos.add(progresso);
                System.out.println("Progresso registrado com sucesso!");
            } catch (ParseException e) {
                System.out.println("Erro ao formatar a data: " + e.getMessage());
            }
        } else {
            System.out.println("Hábito não encontrado.");
        }
    }

    public void visualizarHabitos() {
        for (Habito habito : habitos) {
            System.out.println("Nome: " + habito.getNome());
            System.out.println("Descrição: " + habito.getDescricao());
            System.out.println("Frequência: " + habito.getFrequencia());
            System.out.println("-----------------------------");
        }
    }

    public void visualizarProgressoHabito(Scanner scanner) {
        System.out.print("Nome do Hábito: ");
        String nomeHabito = scanner.nextLine();
        Habito habito = encontrarHabito(nomeHabito);

        if (habito != null) {
            for (Progresso progresso : progressos) {
                if (progresso.getObjetivo().equals(habito)) {
                    System.out.println("Data: " + dateFormat.format(progresso.getData()));
                    System.out.println("Descrição: " + progresso.getDescricao());
                    System.out.println("-----------------------------");
                }
            }
        } else {
            System.out.println("Hábito não encontrado.");
        }
    }

    public Habito encontrarHabito(String nome) {
        for (Habito h : habitos) {
            if (h.getNome().equalsIgnoreCase(nome)) {
                return h;
            }
        }
        return null;
    }

    public void salvarDados() {
        try {
            FileOutputStream fileOut = new FileOutputStream("sistema.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
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
