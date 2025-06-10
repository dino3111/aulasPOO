package ex3a8;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras implements Compra {
    private Map<Produto, Integer> produtos = new HashMap<>();

    @Override
    public void adicionarProduto(Produto produto, int quantidade) {
        if (produtos.containsKey(produto)) {
            produtos.put(produto, produtos.get(produto) + quantidade);
        } else {
            produtos.put(produto, quantidade);
        }
    }

    @Override
    public void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto p = entry.getKey();
            int qtd = entry.getValue();
            System.out.printf("- %s: %d x %.2f€ = %.2f€%n", 
                p.getNome(), qtd, p.getPreco(), qtd * p.getPreco());
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }
}