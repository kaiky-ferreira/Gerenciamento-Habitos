package com.gerenciamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeGerenciamento sistema = new SistemaDeGerenciamento();
        Scanner scanner = new Scanner(System.in);

        sistema.carregarDados();

        while (true) {
            System.out.println("Sistema de Gerenciamento de Hábitos");
            System.out.println("1. Cadastrar Hábito");
            System.out.println("2. Registrar Progresso");
            System.out.println("3. Visualizar Hábitos");
            System.out.println("4. Visualizar Progresso de um Hábito");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    sistema.cadastrarHabito(scanner);
                    break;
                case 2:
                    sistema.registrarProgresso(scanner);
                    break;
                case 3:
                    sistema.visualizarHabitos();
                    break;
                case 4:
                    sistema.visualizarProgressoHabito(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sistema.salvarDados();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
