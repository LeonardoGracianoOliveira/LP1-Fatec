package model;

public class PlacaDeVideo {
    private String fabricante;
    private int linha;
    private int vRam;

    public PlacaDeVideo(String fabricante, int linha, int vRam) {
        this.fabricante = fabricante;
        this.linha = linha;
        this.vRam = vRam;
    }

    // Métodos do UML
    public void renderizar() {
        System.out.println("Placa de vídeo renderizando gráficos...");
    }

    public void minerar() {
        System.out.println("Placa de vídeo minerando criptomoedas...");
    }

    public void esquentar() {
        System.out.println("Placa de vídeo esquentando...");
    }

    @Override
    public String toString() {
        return fabricante + "," + linha + "," + vRam;
    }
}
