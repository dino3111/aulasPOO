package avaliacaoFinal;

public class Concert extends Event {
    private String artista;

    public Concert (String artista, String nome, int duracao) {
        super(nome, duracao);
        this.artista = artista;
    }

    public String getArtista() {
        return this.artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String toString() {
        return super.toString() + ", Artista: " + artista;
    }
}
