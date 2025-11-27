package org.example;

public class Alien {
    private String raca;
    private String nome;
    private int dna;

    public Alien() {}

    public Alien(String raca, String nome, int dna) {
        this.raca = raca;
        this.nome = nome;
        this.dna = dna;
    }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getDna() { return dna; }
    public void setDna(int dna) { this.dna = dna; }

    @Override
    public String toString() {
        return "Alien[raca=" + raca + ", nome=" + nome + ", dna=" + dna + "]";
    }
}