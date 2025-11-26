package model;

public class Relogio {
    private int id;
    private String modelo;
    private String cor;
    private int versao;

    public Relogio() {}

    public Relogio(int id, String modelo, String cor, int versao) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.versao = versao;
    }

    public Relogio(String modelo, String cor, int versao) {
        this(0, modelo, cor, versao);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public int getVersao() { return versao; }
    public void setVersao(int versao) { this.versao = versao; }
}
