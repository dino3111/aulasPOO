package aula08.ex3;

public class Main {
    public static void main(String[] args) {
        ProdutoGenerico produto1 = new ProdutoGenerico("Arroz", 5.0, 10);
        ProdutoComDesconto produto2 = new ProdutoComDesconto("Feijão", 6.0, 5, 10);
        ProdutoGenerico produto3 = new ProdutoGenerico("Maçãs", 2.0, 10);


        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarProduto(produto1, 2);
        carrinho.adicionarProduto(produto2, 3);
        carrinho.adicionarProduto(produto3, 2);


        System.out.println("Produtos no carrinho:");
        carrinho.listarProdutos();

        System.out.println("Total: " + carrinho.calcularTotal());
    }
}

