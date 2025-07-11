public class Personagem {

    public String nome;
    public String classe;
    public int nivel;
    public int vida;
    public int mana;
    public int forca;

    public Personagem(String nome, String classe, int nivel, int vida, int mana, int forca) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = 1;
        this.vida = 100;
        this.mana = mana;
        this.forca = forca;
    }

    public void atacar() {
        System.out.println(nome + " ataca!");
    }

    public void defesa() {
        System.out.println(nome + " se defende!");
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. Vida atual: " + vida);
    }

    public void subirDeNivel() {
        nivel++;
        vida += 20;
        mana += 10;
        forca += 5;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }

    public void mostrarStatus() {
        System.out.println("\nStatus do personagem:");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Força: " + forca);
    }
}

class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, "Mago", 1, 100, 90, 80);
    }

    public void atacar() {
        System.out.println(nome + " lança uma bola de fogo!");
    }

    public void defesa() {
        System.out.println(nome + " cria um escudo mágico!");
    }

    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa feitiço de Ilusão no adversário!");
    }

     public void desenhar() {
        System.out.println("====== MAGO: " + nome + " ======");
        System.out.println("(∩｀-´)⊃━☆ﾟ.*･｡ﾟ");
        System.out.println("   Magia!");
    }
}



class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, "Guerreiro", 1, 100, 50, 70);
    }

    public void atacar() {
        System.out.println(nome + " golpeia com a espada!");
    }

    public void defesa() {
        System.out.println(nome + " bloqueia com o escudo!");
    }

    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa espada de fogo!");
    }

     public void desenhar() {
        System.out.println("====== GUERREIRO: " + nome + " ======");
        System.out.println("O==[:::::::>");
        System.out.println("   Lutando!");
    }
}


class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, "Arqueiro", 1, 100, 35, 60);
    }

    public void atacar() {
        System.out.println(nome + " dispara uma flecha!");
    }

    public void defesa() {
        System.out.println(nome + " se esconde atrás de uma árvore!");
    }

    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa Flecha Explosiva!");
    }

      public void desenhar() {
        System.out.println("====== ARQUEIRO: " + nome + " ======");
        System.out.println("︻デ═一");
        System.out.println("   Mira certeira!");
    }
}
