package org.example;

public class Relogio {
    private String cor;
    private String nome;
    private int versao;

    public Relogio() {}

    public Relogio(String cor, String nome, int versao) {
        this.cor = cor;
        this.nome = nome;
        this.versao = versao;
    }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVersao() { return versao; }
    public void setVersao(int versao) { this.versao = versao; }

    @Override
    public String toString() {
        return "Relogio[cor=" + cor + ", nome=" + nome + ", versao=" + versao + "]";
    }
}