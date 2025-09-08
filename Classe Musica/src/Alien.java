// Classe Aliens
public class Alien {
    private int dna;
    private String raca;
    private boolean habilidadeEspecial;

    public Alien(int dna, String raca, boolean habilidadeEspecial) {
        this.dna = dna;
        this.raca = raca;
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public void comunicar() {
        System.out.println(raca + " está se comunicando.");
    }

    public void invadir() {
        System.out.println(raca + " está invadindo!");
    }

    // Getters e Setters
    public int getDna() { return dna; }
    public void setDna(int dna) { this.dna = dna; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public boolean isHabilidadeEspecial() { return habilidadeEspecial; }
    public void setHabilidadeEspecial(boolean habilidadeEspecial) { this.habilidadeEspecial = habilidadeEspecial; }
}