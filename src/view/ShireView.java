package view;

import entities.Cliente;

import java.util.Scanner;

public class ShireView {
    private final Scanner scanner;

    public ShireView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        boolean entradaValida = false;
        do {
            System.out.println("---Shire Bank---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Verificar Saldo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
            }
        } while (!entradaValida);
        return opcao;
    }

    public int lerAgenciaConta() {
        System.out.print("Digite o número da agência da conta: ");
        return scanner.nextInt();
    }

    public int lerNumeroConta() {
        Scanner scanner = new Scanner(System.in);
        int numeroConta = 0;
        boolean entradaValida = false;
        do {
            System.out.print("Digite o número da conta: ");

            if (scanner.hasNextInt()) {
                numeroConta = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Número de conta inválido. Tente novamente.");
                scanner.nextLine();
            }
        } while (!entradaValida);
        return numeroConta;
    }

    public String lerTitularConta() {
        System.out.print("Digite o nome do titular da conta: ");
        String nome = scanner.next();
        System.out.print("Digite o CPF do titular da conta: ");
        String cpf = scanner.next();
        System.out.print("Digite o CEP do titular da conta: ");
        String cep = scanner.next();

        Cliente titularConta = new Cliente();
        titularConta.setNome(nome);
        titularConta.setCpf(cpf);
        titularConta.setCep(cep);

        return titularConta.getNome();
    }

    public double lerValor() {
        System.out.print("Digite o valor: ");
        return scanner.nextDouble();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
