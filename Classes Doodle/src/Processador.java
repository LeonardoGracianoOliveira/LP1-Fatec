// Classe Processador
public class Processador {
    private String arquitetura;
    private int geracao;
    private int memoria;

    public Processador(String arquitetura, int geracao, int memoria) {
        this.arquitetura = arquitetura;
        this.geracao = geracao;
        this.memoria = memoria;
    }

    public void processar() {
        System.out.println("O processador está processando dados.");
    }

    public void comandar() {
        System.out.println("O processador está comandando instruções.");
    }

    // Getters e Setters
    public String getArquitetura() { return arquitetura; }
    public void setArquitetura(String arquitetura) { this.arquitetura = arquitetura; }

    public int getGeracao() { return geracao; }
    public void setGeracao(int geracao) { this.geracao = geracao; }

    public int getMemoria() { return memoria; }
    public void setMemoria(int memoria) { this.memoria = memoria; }
}