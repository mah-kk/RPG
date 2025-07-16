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

        System.out.println("Escolha seu personagem:");
        System.out.println("1 - Mago (Probabilitor)");
        System.out.println("2 - Guerreiro (Cipher)");
        System.out.println("3 - Arqueiro (Kira)");
        System.out.print("Digite o número do personagem: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        Personagem jogador;
        if (opcao == 1) {
            jogador = mago;
        } else if (opcao == 2) {
            jogador = guerreiro;
        } else if (opcao == 3) {
            jogador = arqueiro;
        } else {
            System.out.println("Opção inválida. Será usado o Guerreiro.");
            jogador = guerreiro;
        }

      
        Personagem oponente;
        do {
            int escolhaOponente = random.nextInt(3) + 1;
            if (escolhaOponente == 1) oponente = mago;
            else if (escolhaOponente == 2) oponente = guerreiro;
            else oponente = arqueiro;
        } while (oponente == jogador);

        System.out.println("\nVocê escolheu: " + jogador.getNome());
        System.out.println("Seu oponente é: " + oponente.getNome());
        System.out.println("Começa a batalha!\n");

        while (jogador.estaVivo() && oponente.estaVivo()) {
     
            System.out.print("Sua açao (ataque ou defesa): ");
            String acao = scanner.nextLine().toLowerCase();

            if (acao.equals("ataque")) {
                int dano = jogador.forca + random.nextInt(6);
                System.out.println("Você ataca e causa " + dano + " de dano!");
                oponente.receberDano(dano);
            } else if (acao.equals("defesa")) {
                int chance = random.nextInt(100);
                if (chance >= 50) {
                    System.out.println("Você defendeu com sucesso!");
                } else {
                    System.out.println("Defesa falhou! Você recebeu 15 de dano.");
                    jogador.receberDano(15);
                }
            } else {
                System.out.println("Ação inválida, você perdeu sua vez.");
            }

            if (!oponente.estaVivo()) break;

          
            int acaoOponente = random.nextInt(2); 
            if (acaoOponente == 0) {
                int dano = oponente.forca + random.nextInt(6);
                System.out.println(oponente.getNome() + " ataca e causa " + dano + " de dano!");
                jogador.receberDano(dano);
            } else {
                int chance = random.nextInt(100);
                if (chance >= 50) {
                    System.out.println(oponente.getNome() + " defendeu com sucesso!");
                } else {
                    System.out.println(oponente.getNome() + " falhou na defesa e recebeu 15 de dano.");
                    oponente.receberDano(15);
                }
            }

           
        }

        if (jogador.estaVivo()) {
            System.out.println("Parabéns! Você venceu a batalha.");
        } else {
            System.out.println("Você perdeu. Sorte na próxima!");
        }

         System.out.println("\nStatus:");
            jogador.mostrarStatus();
            oponente.mostrarStatus();
            System.out.println();

        scanner.close();
    }
}
