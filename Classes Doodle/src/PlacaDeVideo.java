// Classe Placa_de_video
public class PlacaDeVideo {
    private String fabricante;
    private double tamanho;
    private double vram;

    public PlacaDeVideo(String fabricante, double tamanho, double vram) {
        this.fabricante = fabricante;
        this.tamanho = tamanho;
        this.vram = vram;
    }

    public void gerarFrame() {
        System.out.println("A placa de vídeo está gerando frames.");
    }

    public void renderizar() {
        System.out.println("A placa de vídeo está renderizando imagens.");
    }

    // Getters e Setters
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public double getTamanho() { return tamanho; }
    public void setTamanho(double tamanho) { this.tamanho = tamanho; }

    public double getVram() { return vram; }
    public void setVram(double vram) { this.vram = vram; }
}