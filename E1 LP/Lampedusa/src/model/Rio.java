package model;

public class Rio {
    private String nome;
    private int cep;
    private double profundidade;

    public Rio(String nome, int cep, double profundidade) {
        this.nome = nome;
        this.cep = cep;
        this.profundidade = profundidade;
    }

    // Métodos do UML
    public void fluir() {
        System.out.println("O rio está fluindo...");
    }

    public void secar() {
        System.out.println("O rio está secando...");
    }

    public void transbordar() {
        System.out.println("O rio está transbordando...");
    }

    @Override
    public String toString() {
        return nome + "," + cep + "," + profundidade;
    }
}
