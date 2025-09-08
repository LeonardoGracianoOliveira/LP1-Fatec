// Classe Portador
public class Portador {
    private String nome;
    private int idade;
    private String descricao;
    private Relogio relogio; // relação: um portador pode ter um relógio

    public Portador(String nome, int idade, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.descricao = descricao;
    }

    public void interagir() {
        System.out.println(nome + " está interagindo.");
    }

    public void possuir(Relogio relogio) {
        this.relogio = relogio;
        System.out.println(nome + " agora possui o relógio " + relogio.getNome());
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Relogio getRelogio() { return relogio; }
}
