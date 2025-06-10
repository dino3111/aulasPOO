package Teste2020POO;

public abstract class Produto implements PVP{
    String codigo;
    int id ;
    static int contador = 999;
    int quantidade;
    double precobase;
    static double iva = 1.23;
    
    public Produto(String codigo, int quantidade, double precobase) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.precobase = precobase;
    }

    public int  getId() {
        contador++;
        id = contador;
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecobase() {
        return precobase;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecobase(double precobase) {
        this.precobase = precobase;
    }

    public void addStock(int quantidade) {
        this.quantidade += quantidade;
    }

    public int getStock() {
        return getQuantidade();
    }

    public void setStock(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean vender(int quantidade) {
        if(quantidade < getQuantidade()) {
            setQuantidade(getQuantidade() - quantidade);
            return true;
        }
        return false;
    }

    public abstract double precoVendaAoPublico();
    public abstract String getDescricao();

    @Override
    public String toString() {
        return String.format("%s: %10s %s ", getCodigo(), getDescricao(), getStock());
    }
}
