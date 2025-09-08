// Classe Narrador
import java.util.ArrayList;
import java.util.List;

public class Narrador {
    private String nome;
    private int idade;
    private String canal;
    private List<Historia> historias; // muitas histórias

    public Narrador(String nome, int idade, String canal) {
        this.nome = nome;
        this.idade = idade;
        this.canal = canal;
        this.historias = new ArrayList<>();
    }

    public void narrar() {
        System.out.println("O narrador " + nome + " está narrando uma história.");
    }

    public void influenciar() {
        System.out.println("O narrador " + nome + " está influenciando o público.");
    }

    public void adicionarHistoria(Historia historia) {
        historias.add(historia);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }

    public List<Historia> getHistorias() { return historias; }
}