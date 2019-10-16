package Classes;

public class Alimentos {

    private String nome;
    private Double sodio;
    private Double fibras;
    private Double gorduraSaturada;
    private Double colesterol;
    private Double carboidrato;
    private Double acucares;
    private boolean isSaudavel;

    public Alimentos() {

    }

    public Alimentos(String nome, Double sodio, Double fibras, Double gorduraSaturada, Double colesterol,
                                              Double carboidrato, Double acucares, boolean isSaudavel) {
        this.nome = nome;
        this.sodio = sodio;
        this.fibras = fibras;
        this.gorduraSaturada = gorduraSaturada;
        this.colesterol = colesterol;
        this.carboidrato = carboidrato;
        this.acucares = acucares;
        this.isSaudavel = isSaudavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSodio() {
        return sodio;
    }

    public void setSodio(Double sodio) {
        this.sodio = sodio;
    }

    public Double getFibras() {
        return fibras;
    }

    public void setFibras(Double fibras) {
        this.fibras = fibras;
    }

    public Double getGorduraSaturada() {
        return gorduraSaturada;
    }

    public void setGorduraSaturada(Double gorduraSaturada) {
        this.gorduraSaturada = gorduraSaturada;
    }

    public Double getColesterol() {
        return colesterol;
    }

    public void setColesterol(Double colesterol) {
        this.colesterol = colesterol;
    }

    public Double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(Double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public Double getAcucares() {
        return acucares;
    }

    public void setAcucares(Double acucares) {
        this.acucares = acucares;
    }

    public boolean isSaudavel() {
        return isSaudavel;
    }

    public void setSaudavel(boolean saudavel) {
        isSaudavel = saudavel;
    }
}
