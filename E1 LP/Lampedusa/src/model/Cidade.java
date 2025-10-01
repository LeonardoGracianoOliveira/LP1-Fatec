package model;

public class Cidade {
    private String nome;
    private String sigla;
    private int populacao;

    public Cidade(String nome, String sigla, int populacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.populacao = populacao;
    }

    // Métodos do UML
    public void crescer() {
        System.out.println("A cidade está crescendo...");
    }

    public void diminuir() {
        System.out.println("A cidade está diminuindo...");
    }

    public void urbanizar() {
        System.out.println("A cidade está se urbanizando...");
    }

    @Override
    public String toString() {
        return nome + "," + sigla + "," + populacao;
    }
}