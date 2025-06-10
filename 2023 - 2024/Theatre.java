package avaliacaoFinal;

public class Theatre extends Event{
    private String autor;
    private String companhia;

    public Theatre (String nome, String autor, String companhia, int duracao) {
        super(nome, duracao);
        this.autor = autor;
        this.companhia = companhia;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String toString() {
        return super.toString() + ", Autor: " + autor + ", Companhia: " + companhia;
    }
}
