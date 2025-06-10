package Teste2020POO;
import java.util.List;
import java.util.ArrayList;

public class Livro extends Produto {
    String titulo;
    List <Autor> ListdeAutores = new ArrayList<>();
    double iva = 1.06;

    public Livro(String titulo, List<Autor> ListdeAutores) {
        super("L", 0, 0);
        this.titulo = titulo;
        this.ListdeAutores = ListdeAutores;
    }

    public Livro(String titulo, double precobase) {
        super("L", 0, precobase);
        this.titulo = titulo;
    }

    public Livro(String titulo, double precobase,List<Autor> ListdeAutores) {
        super("L", 0, precobase);
        this.titulo = titulo;
        this.ListdeAutores = ListdeAutores;
    }

    public double precoVendaAoPublico() {
        return precobase*iva;
    }

    public void add(Autor autor) {
        ListdeAutores.add(autor);
    }

    public int numeroAutores() {
        return ListdeAutores.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getLista() {
        return ListdeAutores;
    }

    public String getDescricao() {
        return getTitulo();
    }

    public String autores(){
        String s = "";
        for (Autor autor : ListdeAutores) {
            s += autor.toString() + "\n";
        }
        return s;
    }

    

}
