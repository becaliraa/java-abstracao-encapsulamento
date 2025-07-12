package conta_bancaria;

public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double valorUsadoChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
        this.valorUsadoChequeEspecial = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getValorUsadoChequeEspecial() {
        return valorUsadoChequeEspecial;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f%n", limiteChequeEspecial);
    }

    public void depositar(double valor) {
        if (valorUsadoChequeEspecial > 0) {
            double taxa = valorUsadoChequeEspecial * 0.2;
            double valorTotal = valorUsadoChequeEspecial + taxa;
            if (valor >= valorTotal) {
                saldo += (valor - valorTotal);
                System.out.println("Cheque especial quitado com taxa de 20%.");
                valorUsadoChequeEspecial = 0;
            } else {
                double parteQuitada = valor / 1.2;
                valorUsadoChequeEspecial -= parteQuitada;
                System.out.println("Parte do cheque especial quitada.");
            }
        } else {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            double totalDisponivel = saldo + (limiteChequeEspecial - valorUsadoChequeEspecial);
            if (valor <= totalDisponivel) {
                double diferenca = valor - saldo;
                saldo = 0;
                valorUsadoChequeEspecial += diferenca;
                System.out.println("Você usou o cheque especial.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
    }

    public void pagarBoleto(double valor) {
        sacar(valor);
    }

    public void verificarUsoChequeEspecial() {
        if (valorUsadoChequeEspecial > 0) {
            System.out.printf("Você está usando R$ %.2f do cheque especial.%n", valorUsadoChequeEspecial);
        } else {
            System.out.println("Você não está usando o cheque especial.");
        }
    }
}
