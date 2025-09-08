// Classe Historia
import java.util.ArrayList;
import java.util.List;

public class Historia {
    private String nome;
    private int duracao;
    private String criador;
    private List<Narrador> narradores;  // muitos narradores
    private Personagem personagem;      // 0 ou 1 personagem

    public Historia(String nome, int duracao, String criador) {
        this.nome = nome;
        this.duracao = duracao;
        this.criador = criador;
        this.narradores = new ArrayList<>();
    }

    public void durar() {
        System.out.println("A história " + nome + " está durando " + duracao + " minutos.");
    }

    public void impactar() {
        System.out.println("A história " + nome + " impactou o público!");
    }

    public void adicionarNarrador(Narrador narrador) {
        narradores.add(narrador);
    }

    public void definirPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    public String getCriador() { return criador; }
    public void setCriador(String criador) { this.criador = criador; }

    public List<Narrador> getNarradores() { return narradores; }

    public Personagem getPersonagem() { return personagem; }
}