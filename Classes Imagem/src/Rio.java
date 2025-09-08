// Classe Rio
import java.util.ArrayList;
import java.util.List;

public class Rio {
    private String cor;
    private int local;
    private String nome;
    private List<Barco> barcos; // Um rio pode conter vários barcos

    public Rio(String cor, int local, String nome) {
        this.cor = cor;
        this.local = local;
        this.nome = nome;
        this.barcos = new ArrayList<>();
    }

    public void correr() {
        System.out.println("O rio " + nome + " está correndo.");
    }

    public void evaporar() {
        System.out.println("Parte da água do rio " + nome + " está evaporando.");
    }

    public void adicionarBarco(Barco barco) {
        barcos.add(barco);
    }

    // Getters e Setters
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public int getLocal() { return local; }
    public void setLocal(int local) { this.local = local; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Barco> getBarcos() { return barcos; }
}