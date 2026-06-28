package com.gustavo.exercicio01;

public class ContaBancaria {
    double saldo, chequeEspecialInicial;
    double chequeEspecial;

    ContaBancaria(double deposito) {
        this.saldo = deposito;
        chequeEspecial(deposito);
        this.chequeEspecial = chequeEspecialInicial;
    }

    public double getSaldo() {
        return saldo + chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.printf("Você depositou R$%.2f \n", valor);
    }

    public void pagar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else if (valor <= (this.saldo + this.chequeEspecial)){
            var total = valor - this.saldo;
            this.saldo = 0;
            this.chequeEspecial -= total;
        } else {
            System.out.println("Saldo insulficiente");
        }
    }

    public void sacar(double valor) {
        if (valor < this.saldo ) {
            this.saldo -= valor;
            System.out.println("Parabens Saque efetuado com sucesso");
        } else {
            System.out.println("Saldo insulficiente");
        }

    }

    public void chequeEspecial(double valor){
        if (valor <= 500) {
            this.chequeEspecialInicial = 50;
        } else {
            this.chequeEspecialInicial = valor / 2;
        }
    }

    public void consultarCheuqeEspecial() {
        var usoChequeEspecial = (chequeEspecial == chequeEspecialInicial) ?
                "Você ainda nao usou seu saldo"
                : "Você esta Usando o Cheque especial";
        var taxa = (chequeEspecialInicial - chequeEspecial) * 0.2;
        System.out.printf("""
                Cheque especial: R$ %.2f
                %s
                Voce tera que pagar %.2f no inicio do proximo mes
                """,getChequeEspecial(), usoChequeEspecial, taxa);
    }
}
