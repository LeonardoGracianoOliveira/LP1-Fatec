package org.example;

public class Portador {
    private String nome;
    private String descricao;
    private int idade;

    public Portador() {}

    public Portador(String nome, String descricao, int idade) {
        this.nome = nome;
        this.descricao = descricao;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    @Override
    public String toString() {
        return "Portador[nome=" + nome + ", descricao=" + descricao + ", idade=" + idade + "]";
    }
}