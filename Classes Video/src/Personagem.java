// Classe Personagem
public class Personagem {
    private String nome;
    private String aparencia;
    private int idade;

    public Personagem(String nome, String aparencia, int idade) {
        this.nome = nome;
        this.aparencia = aparencia;
        this.idade = idade;
    }

    public void inspirar() {
        System.out.println("O personagem " + nome + " está inspirando outros.");
    }

    public void mudar() {
        System.out.println("O personagem " + nome + " está mudando a história.");
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAparencia() { return aparencia; }
    public void setAparencia(String aparencia) { this.aparencia = aparencia; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
}