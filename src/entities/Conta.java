package entities;

public class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente titular;

    public Conta(int agencia, int numero, Cliente titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            System.out.println("Value can't be less than or equal to zero");
            return;
        }
        this.numero = numero;
    }

    public void setAgencia(int agencia) {
        if (agencia <= 0) {
            System.out.println("Value can't be less than or equal to zero");
            return;
        }
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente.");
        } else {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
