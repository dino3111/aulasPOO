package treino;

public class Travel {
    private static int idCounter = 1;
    private int id;
    private int duracao; // em dias
    private String inicio; // Cidade, País
    private String destino; // Cidade, País

    public Travel(int duracao, String inicio, String destino) {
        this.id = idCounter++;
        this.duracao = duracao;
        this.inicio = inicio;
        this.destino = destino;
    }

    public Travel(int id, int duracao, String inicio, String destino) {
        this.id = id;
        this.duracao = duracao;
        this.inicio = inicio;
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Travel [id =" + id + ", duracao =" + duracao + ", inicio =" + inicio + ", destino =" + destino + "]";
    }
}


