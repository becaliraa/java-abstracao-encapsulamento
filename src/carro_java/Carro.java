package carro_java;

public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha; // 0 a 6

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0; // ponto morto
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("Carro já está ligado.");
        }
    }

    public void desligar() {
        if (ligado && velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Para desligar, o carro deve estar parado e em ponto morto.");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado, não pode acelerar.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Carro em ponto morto, não pode acelerar.");
            return;
        }
        int maxVel = getVelocidadeMaximaPorMarcha();
        if (velocidade < maxVel) {
            velocidade++;
            System.out.printf("Velocidade atual: %d km/h%n", velocidade);
        } else {
            System.out.println("Velocidade máxima da marcha atingida.");
        }
    }

    public void diminuirVelocidade() {
        if (!ligado) {
            System.out.println("O carro está desligado, não pode diminuir velocidade.");
            return;
        }
        if (velocidade > 0) {
            velocidade--;
            System.out.printf("Velocidade atual: %d km/h%n", velocidade);
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado, não pode trocar marcha.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
            return;
        }
        if (Math.abs(novaMarcha - this.marcha) > 1) {
            System.out.println("Não é permitido pular marcha.");
            return;
        }
        int minVel = getVelocidadeMinimaPorMarcha(novaMarcha);
        int maxVel = getVelocidadeMaximaPorMarcha(novaMarcha);
        if (velocidade < minVel || velocidade > maxVel) {
            System.out.printf("Velocidade atual %d km/h não está dentro do intervalo permitido para a marcha %d (%d-%d km/h).%n",
                    velocidade, novaMarcha, minVel, maxVel);
            return;
        }
        this.marcha = novaMarcha;
        System.out.printf("Marcha trocada para %d.%n", marcha);
    }

    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado, não pode virar.");
            return;
        }
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Para virar, a velocidade deve estar entre 1 km/h e 40 km/h.");
            return;
        }
        if (direcao.equalsIgnoreCase("esquerda") || direcao.equalsIgnoreCase("direita")) {
            System.out.printf("Virando para %s.%n", direcao);
        } else {
            System.out.println("Direção inválida. Use 'esquerda' ou 'direita'.");
        }
    }

    private int getVelocidadeMaximaPorMarcha() {
        return getVelocidadeMaximaPorMarcha(this.marcha);
    }

    private int getVelocidadeMaximaPorMarcha(int marcha) {
        switch (marcha) {
            case 1: return 20;
            case 2: return 40;
            case 3: return 60;
            case 4: return 80;
            case 5: return 100;
            case 6: return 120;
            default: return 0;
        }
    }

    private int getVelocidadeMinimaPorMarcha(int marcha) {
        switch (marcha) {
            case 1: return 0;
            case 2: return 21;
            case 3: return 41;
            case 4: return 61;
            case 5: return 81;
            case 6: return 101;
            default: return 0;
        }
    }
}
