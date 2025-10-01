package model;

public class Relogio {
    private String cor;
    private int versao;
    private String nome;

    public Relogio(String cor, int versao, String nome) {
        this.cor = cor;
        this.versao = versao;
        this.nome = nome;
    }

    // Métodos do UML
    public void ativar() {
        System.out.println("Relógio ativado...");
    }

    public void desligar() {
        System.out.println("Relógio desligado...");
    }

    public void carregar() {
        System.out.println("Relógio carregando...");
    }

    @Override
    public String toString() {
        return cor + "," + versao + "," + nome;
    }
}
