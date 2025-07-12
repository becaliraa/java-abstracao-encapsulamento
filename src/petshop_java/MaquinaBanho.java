package petshop_java;

public class MaquinaBanho {
    private int agua; // litros
    private int shampoo; // litros
    private boolean petNoBanho;
    private boolean petLimpo;

    private final int capacidadeMaxAgua = 30;
    private final int capacidadeMaxShampoo = 10;

    public MaquinaBanho() {
        this.agua = 0;
        this.shampoo = 0;
        this.petNoBanho = false;
        this.petLimpo = false;
    }

    public void abastecerAgua() {
        if (agua + 2 <= capacidadeMaxAgua) {
            agua += 2;
            System.out.println("2 litros de água adicionados. Água total: " + agua + " litros.");
        } else {
            System.out.println("Capacidade máxima de água atingida.");
        }
    }

    public void abastecerShampoo() {
        if (shampoo + 2 <= capacidadeMaxShampoo) {
            shampoo += 2;
            System.out.println("2 litros de shampoo adicionados. Shampoo total: " + shampoo + " litros.");
        } else {
            System.out.println("Capacidade máxima de shampoo atingida.");
        }
    }

    public void colocarPet() {
        if (petNoBanho) {
            System.out.println("Já tem um pet na máquina.");
        } else if (!petLimpo) {
            System.out.println("A máquina precisa ser limpa antes de receber outro pet.");
        } else {
            petNoBanho = true;
            petLimpo = false;
            System.out.println("Pet colocado na máquina para banho.");
        }
    }

    public void darBanho() {
        if (!petNoBanho) {
            System.out.println("Não há pet na máquina para dar banho.");
            return;
        }
        if (agua < 10) {
            System.out.println("Não há água suficiente para o banho.");
            return;
        }
        if (shampoo < 2) {
            System.out.println("Não há shampoo suficiente para o banho.");
            return;
        }
        agua -= 10;
        shampoo -= 2;
        petLimpo = true;
        System.out.println("Banho dado no pet. Água restante: " + agua + ", Shampoo restante: " + shampoo);
    }

    public void retirarPet() {
        if (!petNoBanho) {
            System.out.println("Não há pet na máquina para retirar.");
            return;
        }
        if (!petLimpo) {
            System.out.println("Pet não está limpo. É necessário limpar a máquina antes de receber outro pet.");
        }
        petNoBanho = false;
        petLimpo = false;
        System.out.println("Pet retirado da máquina.");
    }

    public void limparMaquina() {
        if (agua < 3) {
            System.out.println("Não há água suficiente para limpar a máquina.");
            return;
        }
        if (shampoo < 1) {
            System.out.println("Não há shampoo suficiente para limpar a máquina.");
            return;
        }
        agua -= 3;
        shampoo -= 1;
        petLimpo = true;
        System.out.println("Máquina limpa. Água restante: " + agua + ", Shampoo restante: " + shampoo);
    }

    public void verificarNivelAgua() {
        System.out.println("Nível de água: " + agua + " litros.");
    }

    public void verificarNivelShampoo() {
        System.out.println("Nível de shampoo: " + shampoo + " litros.");
    }

    public void verificarPetNoBanho() {
        if (petNoBanho) {
            System.out.println("Tem um pet na máquina.");
        } else {
            System.out.println("Não há pet na máquina.");
        }
    }
}
