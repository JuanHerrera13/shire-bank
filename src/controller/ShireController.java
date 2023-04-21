package controller;

import entities.Cliente;
import entities.Conta;
import view.ShireView;

import java.util.HashMap;
import java.util.Map;

public class ShireController {
    private Map<Integer, Conta> contas;
    private ShireView view;

    public static void main(String[] args) {
        ShireController shireController = new ShireController();
        shireController.executar();
    }

    public ShireController() {
        this.contas = new HashMap<>();
        this.view = new ShireView();
    }

    public void executar() {
        int opcao;
        while (true) {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    verificarSaldo();
                    break;
                case 6:
                    view.exibirMensagem("Encerrando o programa...");
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    private void criarConta() {
        int numeroConta = view.lerNumeroConta();
        if (verificarContaExistente(numeroConta)) {
            view.exibirMensagem("Número de conta já existente. Tente novamente com um número de conta diferente.");
        } else {
            int agenciaConta = view.lerAgenciaConta();
            Cliente titularConta = new Cliente();
            titularConta.setNome(view.lerTitularConta());
            Conta conta = new Conta(agenciaConta, numeroConta, titularConta.getNome());
            contas.put(numeroConta, conta);
            view.exibirMensagem("Conta criada com sucesso.");
        }
    }

    private boolean verificarContaExistente(int numeroConta) {
        return contas.containsKey(numeroConta);
    }

    private void depositar() {
        int numeroConta = view.lerNumeroConta();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            double valor = view.lerValor();
            conta.depositar(valor);
            view.exibirMensagem("Depósito realizado com sucesso.");
        } else {
            view.exibirMensagem("Conta não encontrada. Verifique o número da conta.");
        }
    }

    private void sacar() {
        int numeroConta = view.lerNumeroConta();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            double valor = view.lerValor();
            conta.sacar(valor);
        } else {
            view.exibirMensagem("Conta não encontrada. Verifique o número da conta.");
        }
    }

    private void transferir() {
        System.out.println("Primeiro número da conta => Origem\nSegundo número da conta => Destino");
        int numeroContaOrigem = view.lerNumeroConta();
        int numeroContaDestino = view.lerNumeroConta();
        double valor = view.lerValor();
        Conta contaOrigem = contas.get(numeroContaOrigem);
        Conta contaDestino = contas.get(numeroContaDestino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        } else {
            view.exibirMensagem("Conta de origem ou conta de destino não encontrada. Verifique os números das contas.");
        }
    }

    private void verificarSaldo() {
        int numeroConta = view.lerNumeroConta();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            double saldo = conta.getSaldo();
            view.exibirMensagem("Saldo da conta " + numeroConta + ": R$" + saldo);
        } else {
            view.exibirMensagem("Conta não encontrada.");
        }
    }
}
