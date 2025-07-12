package conta_bancaria;

import java.util.Scanner;

public class MenuContaBancaria {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o valor inicial para criar a conta: R$ ");
        double valorInicial = scanner.nextDouble();
        ContaBancaria conta = new ContaBancaria(valorInicial);

        int opcao;
        do {
            System.out.println("\n--- Menu Conta Bancária ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso do cheque especial");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.print("Valor do depósito: R$ ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 4:
                    System.out.print("Valor do saque: R$ ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 5:
                    System.out.print("Valor do boleto: R$ ");
                    double boleto = scanner.nextDouble();
                    conta.pagarBoleto(boleto);
                    break;
                case 6:
                    conta.verificarUsoChequeEspecial();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
