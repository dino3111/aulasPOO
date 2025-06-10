package teste2223poo;

public class Client {

    public enum TipoCliente {
        PERSONAL, ENTERPRISE
    }

    private String nome;
    private TipoCliente type;
    private String nrContribuinte;

    public Client(String nrContribuinte, String nome, TipoCliente type) {
        this.nrContribuinte = nrContribuinte;
        this.nome = nome;
        this.type = type;
    }

    public String getNrContribuinte() {
        return nrContribuinte;
    }

    public String getNome() {
        return nome;
    }

    public TipoCliente getTipo() {
        return type;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(TipoCliente type) {
        this.type = type;
    }

    public String getTaxId() {
        return nrContribuinte;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nrContribuinte='" + nrContribuinte + '\'' +
                ", nome='" + nome + '\'' +
                ", tipo=" + type +
                '}';
    }
}