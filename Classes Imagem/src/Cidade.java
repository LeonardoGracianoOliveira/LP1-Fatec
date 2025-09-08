// Classe Cidade
import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private String nome;
    private String sigla;
    private int local;
    private List<Rio> rios; // Uma cidade pode conter vários rios

    public Cidade(String nome, String sigla, int local) {
        this.nome = nome;
        this.sigla = sigla;
        this.local = local;
        this.rios = new ArrayList<>();
    }

    public void abrigar() {
        System.out.println("A cidade " + nome + " está abrigando pessoas.");
    }

    public void andar() {
        System.out.println("Pessoas estão andando na cidade " + nome + ".");
    }

    public void adicionarRio(Rio rio) {
        rios.add(rio);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public int getLocal() { return local; }
    public void setLocal(int local) { this.local = local; }

    public List<Rio> getRios() { return rios; }
}