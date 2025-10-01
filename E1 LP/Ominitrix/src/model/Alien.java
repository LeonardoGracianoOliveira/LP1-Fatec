package model;

public class Alien {
    private String raca;
    private String planetaDeOrigem;
    private long dna;

    public Alien(String raca, String planetaDeOrigem, long dna) {
        this.raca = raca;
        this.planetaDeOrigem = planetaDeOrigem;
        this.dna = dna;
    }

    // Métodos do UML
    public void transformar() {
        System.out.println("Alien se transformando...");
    }

    public void atacar() {
        System.out.println("Alien atacando...");
    }

    public void defender() {
        System.out.println("Alien defendendo...");
    }

    @Override
    public String toString() {
        return raca + "," + planetaDeOrigem + "," + dna;
    }
}