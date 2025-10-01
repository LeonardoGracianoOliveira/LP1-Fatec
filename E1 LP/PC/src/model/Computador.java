package model;

public class Computador {
    private double tamanho;
    private String marca;
    private String cor;

    public Computador(double tamanho, String marca, String cor) {
        this.tamanho = tamanho;
        this.marca = marca;
        this.cor = cor;
    }

    // Métodos do UML
    public void ligar() {
        System.out.println("Computador ligado...");
    }

    public void desligar() {
        System.out.println("Computador desligado...");
    }

    public void reiniciar() {
        System.out.println("Computador reiniciando...");
    }

    @Override
    public String toString() {
        return tamanho + "," + marca + "," + cor;
    }
}
