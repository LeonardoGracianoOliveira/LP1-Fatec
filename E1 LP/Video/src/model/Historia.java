package model;

public class Historia {
    private String nome;
    private int duracao;
    private String criador;

    public Historia(String nome, int duracao, String criador) {
        this.nome = nome;
        this.duracao = duracao;
        this.criador = criador;
    }

    // Métodos do UML
    public void iniciar() {
        System.out.println("História iniciada...");
    }

    public void pausar() {
        System.out.println("História pausada...");
    }

    public void encerrar() {
        System.out.println("História encerrada...");
    }

    @Override
    public String toString() {
        return nome + "," + duracao + "," + criador;
    }
}
