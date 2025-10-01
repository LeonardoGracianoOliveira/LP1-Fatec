package model;

public class Barco {
    private String material;
    private double tamanho;
    private double peso;

    public Barco(String material, double tamanho, double peso) {
        this.material = material;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    // Métodos do UML
    public void navegar() {
        System.out.println("O barco está navegando...");
    }

    public void ancorar() {
        System.out.println("O barco ancorou...");
    }

    public void atracar() {
        System.out.println("O barco atracou...");
    }

    @Override
    public String toString() {
        return material + "," + tamanho + "," + peso;
    }
}
