package aula08.ex3;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras implements Compra {
    private List<Produto> produtos;

    public CarrinhoDeCompras() {
        produtos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getQuantidade() >= quantidade) {
            produto.removerQuantidade(quantidade); 
            produtos.add(produto);                  
        } else {
            System.out.println("Quantidade insuficiente no estoque.");
        }
    }

    @Override
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println("Produto: " + produto.getNome() + " | Preço: " + produto.getPreco() + " | Quantidade: 1");
            }
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
}

