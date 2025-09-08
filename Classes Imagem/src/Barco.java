// Classe Barco
public class Barco {
    private String material;
    private double tamanho;
    private double peso;

    public Barco(String material, double tamanho, double peso) {
        this.material = material;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    public void navegar() {
        System.out.println("O barco de material " + material + " está navegando.");
    }

    public void transportar() {
        System.out.println("O barco de material " + material + " está transportando cargas/pessoas.");
    }

    // Getters e Setters
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public double getTamanho() { return tamanho; }
    public void setTamanho(double tamanho) { this.tamanho = tamanho; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}