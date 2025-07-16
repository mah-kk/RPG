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
            System.out.println("Opção invalida. Sera usado o Guerreiro.");
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
        jogador.desenhar();
        System.out.println("Seu oponente é: " + oponente.getNome());
        oponente.desenhar();
        System.out.println("Começa a batalha!\n");

        while (jogador.estaVivo() && oponente.estaVivo()) {
            System.out.print("Sua acao (ataque, defesa ou especial): ");
            String acao = scanner.nextLine().toLowerCase();

            if (acao.equals("ataque")) {
                jogador.atacar();
                int dano = jogador.forca + random.nextInt(6);
                System.out.println("Você causou " + dano + " de dano!");
                oponente.receberDano(dano);
            } else if (acao.equals("defesa")) {
                jogador.defesa();
                int chance = random.nextInt(100);
                if (chance >= 50) {
                    System.out.println("Você defendeu com sucesso!");
                } else {
                    System.out.println("Defesa falhou! Você recebeu 15 de dano.");
                    jogador.receberDano(15);
                }
            } else if (acao.equals("especial")) {
                if (jogador instanceof Mago) {
                    ((Mago) jogador).usarHabilidadeEspecial();
                } else if (jogador instanceof Guerreiro) {
                    ((Guerreiro) jogador).usarHabilidadeEspecial();
                } else if (jogador instanceof Arqueiro) {
                    ((Arqueiro) jogador).usarHabilidadeEspecial();
                }
            } else {
                System.out.println("Açao invalida, você perdeu sua vez.");
            }

            if (!oponente.estaVivo()) break;

            System.out.println("\nTurno do oponente...");
            int acaoOponente = random.nextInt(3);
            if (acaoOponente == 0) {
                oponente.atacar();
                int dano = oponente.forca + random.nextInt(6);
                System.out.println("Você recebeu " + dano + " de dano!");
                jogador.receberDano(dano);
            } else if (acaoOponente == 1) {
                oponente.defesa();
                int chance = random.nextInt(100);
                if (chance >= 50) {
                    System.out.println("Oponente defendeu com sucesso!");
                } else {
                    System.out.println("Oponente falhou na defesa e recebeu 15 de dano.");
                    oponente.receberDano(15);
                }
            } else {
                if (oponente instanceof Mago) {
                    ((Mago) oponente).usarHabilidadeEspecial();
                } else if (oponente instanceof Guerreiro) {
                    ((Guerreiro) oponente).usarHabilidadeEspecial();
                } else if (oponente instanceof Arqueiro) {
                    ((Arqueiro) oponente).usarHabilidadeEspecial();
                }
            }

            System.out.println();
        }

        if (jogador.estaVivo()) {
            System.out.println("Parabens! Você venceu a batalha.");
            jogador.subirDeNivel();
        } else {
            System.out.println("Você perdeu. Sorte na próxima!");
        }

        System.out.println("\nStatus Final:");
        jogador.mostrarStatus();
        oponente.mostrarStatus();

        scanner.close();
    }
}