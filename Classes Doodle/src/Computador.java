// Classe Computador
public class Computador {
    private String marca;
    private String cor;
    private String nome;
    private Processador processador;     // relação obrigatória (1,1)
    private PlacaDeVideo placaDeVideo;   // relação opcional (0,1)

    public Computador(String marca, String cor, String nome, Processador processador) {
        this.marca = marca;
        this.cor = cor;
        this.nome = nome;
        this.processador = processador;
    }

    public void transportar() {
        System.out.println("O computador " + nome + " está sendo transportado.");
    }

    public void formatar() {
        System.out.println("O computador " + nome + " está sendo formatado.");
    }

    public void instalarPlacaDeVideo(PlacaDeVideo placa) {
        this.placaDeVideo = placa;
    }

    // Getters e Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Processador getProcessador() { return processador; }
    public void setProcessador(Processador processador) { this.processador = processador; }

    public PlacaDeVideo getPlacaDeVideo() { return placaDeVideo; }
}