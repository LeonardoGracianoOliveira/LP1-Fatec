package model;

public class Narrador {
    private String nome;
    private int idade;
    private String aparencia;

    public Narrador(String nome, int idade, String aparencia) {
        this.nome = nome;
        this.idade = idade;
        this.aparencia = aparencia;
    }

    // Métodos do UML
    public void narrar() {
        System.out.println("Narrador narrando a história...");
    }

    public void influenciar() {
        System.out.println("Narrador influenciando...");
    }

    public void apresentar() {
        System.out.println("Narrador apresentando...");
    }

    @Override
    public String toString() {
        return nome + "," + idade + "," + aparencia;
    }
}