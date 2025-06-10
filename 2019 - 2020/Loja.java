package Teste2020POO;
import java.util.TreeSet;
import java.util.Set;

public class Loja {
    String nome;
    String enderecoweb;
    Set<Produto> produtos;

    public Loja(String nome, String enderecoweb) {
        this.nome = nome;
        this.enderecoweb = enderecoweb;
        this.produtos = new TreeSet<>( (p1, p2) -> p1.getDescricao().compareTo(p2.getDescricao()) );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public String getEnderecoweb() {
        return enderecoweb;
    }

    public void setEnderecoWeb(String enderecoweb) {
        if (enderecoweb.length() > 0) {
            this.enderecoweb = enderecoweb;
        }
    }

    public void setEnderecoweb(String enderecoweb) {
        this.enderecoweb = enderecoweb;
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public int totalItems(){
        int total = 0;
        for (Produto produto : produtos) {
            total+=produto.getQuantidade();
        }
        return total;
    }

    public String getProdutoPelaDescricao(String descricao) {
        for (Produto produto : produtos) {

            if (produto instanceof Telemovel){
                String d = descricao.substring(1, descricao.indexOf("/"));
                d=d.toLowerCase();
                descricao=descricao.substring(0, 1) + d + descricao.substring(descricao.indexOf("/"));
            }
            if(produto.getDescricao().equals(descricao)) {
                return produto.getDescricao();
            }
        }
        return null;
    }

    public Set<Produto> reorder(){
        Set<Produto> produtos2 = new TreeSet<>( (p1, p2) -> p1.getDescricao().compareTo(p2.getDescricao()) );
        for (Produto produto : produtos) {
            produtos2.add(produto);
        }
        produtos = produtos2;
        return produtos;
    }



    @Override
    public String toString() {
        String str = "";
        System.out.println("Loja" + getNome() + "\n");
        str+=String.format ("%s %s %30s %6s\n", "Codigo", "Produto", "Em Stock", "PVP");
        for (Produto produto : produtos) {
            str+= String.format ("%s%d: %-25s %12s %.2f\n", produto.getCodigo(),produto.getId(), produto.getDescricao(), produto.getStock(),produto.precoVendaAoPublico());

        }
        return str;
    }

}
