package carro_java;


import java.util.Scanner;

public class MenuCarro {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        int opcao;
        do {
            System.out.println("\n--- Menu Controle de Carro ---");
            System.out.println("1. Ligar carro");
            System.out.println("2. Desligar carro");
            System.out.println("3. Acelerar");
            System.out.println("4. Diminuir velocidade");
            System.out.println("5. Trocar marcha");
            System.out.println("6. Virar para esquerda");
            System.out.println("7. Virar para direita");
            System.out.println("8. Verificar velocidade");
            System.out.println("9. Verificar marcha");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.diminuirVelocidade();
                    break;
                case 5:
                    System.out.print("Informe a nova marcha (0 a 6): ");
                    int marcha = scanner.nextInt();
                    carro.trocarMarcha(marcha);
                    break;
                case 6:
                    carro.virar("esquerda");
                    break;
                case 7:
                    carro.virar("direita");
                    break;
                case 8:
                    System.out.println("Velocidade atual: " + carro.getVelocidade() + " km/h");
                    break;
                case 9:
                    System.out.println("Marcha atual: " + carro.getMarcha());
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
