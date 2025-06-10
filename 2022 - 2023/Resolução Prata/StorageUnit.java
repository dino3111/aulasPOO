package teste2223;

public class StorageUnit {
    private String localizacao;
    private int[] dimensoes;
    private double preco;


    public StorageUnit(String localizacao, int[] dimensoes, double preco) {
        this.localizacao = localizacao;
        this.dimensoes = dimensoes;
        this.preco = preco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int[] getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(int[] dimensoes) {
        this.dimensoes = dimensoes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString() {
        return "Localização: " + ", comprimento: " + ", largura" + ", preço: " + preco + " €";
    }
}
