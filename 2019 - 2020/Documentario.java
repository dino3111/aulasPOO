package Teste2020POO;

public class Documentario extends Produto{
    String titulo;
    int ano;
    int duracaomin;
    double iva = 1.23;

    public Documentario(String titulo, int ano, int duracaomin, double precobase) {
        super("D", 0, precobase);
        this.titulo = titulo;
        this.ano = ano;
        this.duracaomin = duracaomin;
    }

    public double precoVendaAoPublico() {
        return precobase*iva;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return getTitulo();
    }

}
