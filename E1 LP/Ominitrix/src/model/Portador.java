package model;

public class Portador {
    private String nome;
    private int idade;
    private String aparencia;

    public Portador(String nome, int idade, String aparencia) {
        this.nome = nome;
        this.idade = idade;
        this.aparencia = aparencia;
    }

    // Métodos do UML
    public void usarRelogio() {
        System.out.println("Portador usando o Omnitrix...");
    }

    public void correr() {
        System.out.println("Portador correndo...");
    }

    public void lutar() {
        System.out.println("Portador lutando...");
    }

    @Override
    public String toString() {
        return nome + "," + idade + "," + aparencia;
    }
}