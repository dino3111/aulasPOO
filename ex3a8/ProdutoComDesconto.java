package ex3a8;

public class ProdutoComDesconto extends ProdutoGenerico {
    private float desconto;
    
    public ProdutoComDesconto(String nome, double preco, int stock, float desconto) {
        super(nome, preco, stock);
        this.desconto = desconto;
    }

    @Override
    public double getPreco() {
        return super.getPreco() * (1 - desconto / 100);
    }
}