package teste2223;

public class Client {
    private int nif;
    private String nome;
    private ClientType tipo;

    public Client(int nif, String nome, ClientType tipo) {
        this.nif = nif;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClientType getTipo() {
        return tipo;
    }

    public void setTipo(ClientType tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "Nome: " + nome + ", NIF: " + nif + ", Endereço: " + tipo;
    }
}
