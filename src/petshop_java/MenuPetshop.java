package petshop_java;

import java.util.Scanner;

public class MenuPetshop {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        MaquinaBanho maquina = new MaquinaBanho();

        int opcao;
        do {
            System.out.println("\n--- Menu Máquina de Banho Petshop ---");
            System.out.println("1. Abastecer água");
            System.out.println("2. Abastecer shampoo");
            System.out.println("3. Colocar pet na máquina");
            System.out.println("4. Dar banho no pet");
            System.out.println("5. Retirar pet da máquina");
            System.out.println("6. Limpar máquina");
            System.out.println("7. Verificar nível de água");
            System.out.println("8. Verificar nível de shampoo");
            System.out.println("9. Verificar se tem pet na máquina");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    maquina.abastecerAgua();
                    break;
                case 2:
                    maquina.abastecerShampoo();
                    break;
                case 3:
                    maquina.colocarPet();
                    break;
                case 4:
                    maquina.darBanho();
                    break;
                case 5:
                    maquina.retirarPet();
                    break;
                case 6:
                    maquina.limparMaquina();
                    break;
                case 7:
                    maquina.verificarNivelAgua();
                    break;
                case 8:
                    maquina.verificarNivelShampoo();
                    break;
                case 9:
                    maquina.verificarPetNoBanho();
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
