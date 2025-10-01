package model;

public class Personagem {
    private String nome;
    private int idade;
    private String aparencia;

    public Personagem(String nome, int idade, String aparencia) {
        this.nome = nome;
        this.idade = idade;
        this.aparencia = aparencia;
    }

    // Métodos do UML
    public void falar() {
        System.out.println("Personagem falando...");
    }

    public void agir() {
        System.out.println("Personagem agindo...");
    }

    public void lutar() {
        System.out.println("Personagem lutando...");
    }

    @Override
    public String toString() {
        return nome + "," + idade + "," + aparencia;
    }
}