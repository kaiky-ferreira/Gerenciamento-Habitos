package com.gerenciamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeGerenciamento sistema = new SistemaDeGerenciamento();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        sistema.carregarDados();

        while (true) {
            System.out.println("Sistema de Gerenciamento de Metas e Hábitos");
            System.out.println("1. Cadastrar Meta");
            System.out.println("2. Cadastrar Hábito");
            System.out.println("3. Registrar Progresso");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Meta: ");
                    String nomeMeta = scanner.nextLine();
                    System.out.print("Descrição da Meta: ");
                    String descricaoMeta = scanner.nextLine();
                    System.out.print("Data de Início (dd-MM-yyyy): ");
                    String dataInicioMeta = scanner.nextLine();
                    System.out.print("Data de Término (dd-MM-yyyy): ");
                    String dataTerminoMeta = scanner.nextLine();

                    try {
                        Date dataInicio = dateFormat.parse(dataInicioMeta);
                        Date dataTermino = dateFormat.parse(dataTerminoMeta);
                        Meta meta = new Meta(nomeMeta, descricaoMeta, dataInicio, dataTermino);
                        sistema.cadastrarMeta(meta);
                        System.out.println("Meta cadastrada com sucesso!");
                    } catch (ParseException e) {
                        System.out.println("Erro ao cadastrar meta: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Nome do Hábito: ");
                    String nomeHabito = scanner.nextLine();
                    System.out.print("Descrição do Hábito: ");
                    String descricaoHabito = scanner.nextLine();
                    System.out.print("Frequência do Hábito: ");
                    String frequenciaHabito = scanner.nextLine();

                    Habito habito = new Habito(nomeHabito, descricaoHabito, frequenciaHabito);
                    sistema.cadastrarHabito(habito);
                    System.out.println("Hábito cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.print("Progresso para (Meta/Hábito): ");
                    String tipo = scanner.nextLine();
                    Object objetivo = null;
                    if (tipo.equalsIgnoreCase("Meta")) {
                        System.out.print("Nome da Meta: ");
                        String nome = scanner.nextLine();
                        for (Meta m : sistema.getMetas()) {
                            if (m.getNome().equalsIgnoreCase(nome)) {
                                objetivo = m;
                                break;
                            }
                        }
                    } else if (tipo.equalsIgnoreCase("Hábito")) {
                        System.out.print("Nome do Hábito: ");
                        String nome = scanner.nextLine();
                        for (Habito h : sistema.getHabitos()) {
                            if (h.getNome().equalsIgnoreCase(nome)) {
                                objetivo = h;
                                break;
                            }
                        }
                    }

                    if (objetivo != null) {
                        System.out.print("Data do Progresso (dd-MM-yyyy): ");
                        String dataProgresso = scanner.nextLine();
                        System.out.print("Descrição do Progresso: ");
                        String descricaoProgresso = scanner.nextLine();

                        try {
                            Date data = dateFormat.parse(dataProgresso);
                            Progresso progresso = new Progresso(objetivo, data, descricaoProgresso);
                            sistema.adicionarProgresso(progresso);
                            System.out.println("Progresso registrado com sucesso!");
                        } catch (ParseException e) {
                            System.out.println("Erro ao formatar a data: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Meta ou Hábito não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    // Salvar dados antes de sair
                    sistema.salvarDados();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
