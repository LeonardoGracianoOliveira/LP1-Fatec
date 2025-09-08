// Classe Relogio
import java.util.ArrayList;
import java.util.List;

public class Relogio {
    private String cor;
    private String nome;
    private int versao;
    private List<Alien> aliens; // relação: um relógio tem vários aliens

    public Relogio(String cor, String nome, int versao) {
        this.cor = cor;
        this.nome = nome;
        this.versao = versao;
        this.aliens = new ArrayList<>();
    }

    public void mostrar() {
        System.out.println("Relógio: " + nome + " | Cor: " + cor + " | Versão: " + versao);
    }

    public void atualizar(int novaVersao) {
        this.versao = novaVersao;
        System.out.println("Relógio " + nome + " atualizado para versão " + versao);
    }

    public void adicionarAlien(Alien alien) {
        aliens.add(alien);
    }

    // Getters e Setters
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVersao() { return versao; }
    public void setVersao(int versao) { this.versao = versao; }

    public List<Alien> getAliens() { return aliens; }
}