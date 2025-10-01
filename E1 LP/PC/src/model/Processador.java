package model;

public class Processador {
    private String arquitetura;
    private int memoria;
    private int geracao;

    public Processador(String arquitetura, int memoria, int geracao) {
        this.arquitetura = arquitetura;
        this.memoria = memoria;
        this.geracao = geracao;
    }

    // Métodos do UML
    public void processar() {
        System.out.println("Processador processando dados...");
    }

    public void calcular() {
        System.out.println("Processador realizando cálculos...");
    }

    public void aquecer() {
        System.out.println("Processador esquentando...");
    }

    @Override
    public String toString() {
        return arquitetura + "," + memoria + "," + geracao;
    }
}
