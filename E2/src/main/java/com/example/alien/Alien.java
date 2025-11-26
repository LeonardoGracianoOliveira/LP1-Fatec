package model;

public class Alien {
    private int id;
    private String nome;
    private String planetaDeOrigem;
    private int dna;

    public Alien() {}

    public Alien(int id, String nome, String planetaDeOrigem, int dna) {
        this.id = id;
        this.nome = nome;
        this.planetaDeOrigem = planetaDeOrigem;
        this.dna = dna;
    }

    public Alien(String nome, String planetaDeOrigem, int dna) {
        this(0, nome, planetaDeOrigem, dna);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPlanetaDeOrigem() { return planetaDeOrigem; }
    public void setPlanetaDeOrigem(String planetaDeOrigem) { this.planetaDeOrigem = planetaDeOrigem; }

    public int getDna() { return dna; }
    public void setDna(int dna) { this.dna = dna; }
}
