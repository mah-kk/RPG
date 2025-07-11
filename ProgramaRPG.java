import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class ProgramaRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(new Locale("pt", "BR"));
        Random random = new Random();

        Mago mago = new Mago("Probabilitor");
        Guerreiro guerreiro = new Guerreiro("Cipher");
        Arqueiro arqueiro = new Arqueiro("Kira");

        System.out.println("Escolha um personagem:");
        System.out.println("1 - Mago (Probabilitor)");
        System.out.println("2 - Guerreiro (Cipher)");
        System.out.println("3 - Arqueiro (Kira)");
        System.out.print("Digite o número do personagem: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        
        Personagem escolhido;

        if (opcao == 1) {
            escolhido = mago;
        } else if (opcao == 2) {
            escolhido = guerreiro;
        } else if (opcao == 3) {
            escolhido = arqueiro;
        } else {
            System.out.println("Opção inválida. Será usado o Guerreiro.");
            escolhido = guerreiro;
        }

        System.out.print("\nDigite sua ação (ataque ou defesa): ");
        String acao = scanner.nextLine().toLowerCase();

 
        int chance = random.nextInt(100);

        if (acao.equals("ataque")) {
            escolhido.atacar();
            int dano = escolhido.forca + random.nextInt(6);
            System.out.println("Você causou " + dano + " de dano!");
        } else if (acao.equals("defesa")) {
            escolhido.defesa();
            if (chance >= 50) {
                System.out.println("Defesa bem-sucedida!");
            } else {
                System.out.println("Defesa falhou! Recebeu 15 de dano.");
                escolhido.receberDano(15);
            }
        } else {
            System.out.println("Ação inválida!");
        }

        escolhido.mostrarStatus();
        scanner.close();
    }
}


