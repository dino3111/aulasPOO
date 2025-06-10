package teste2223;

import java.util.List;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;


public class StorageService implements StorageServiceInterface {
    private String nome;
    private String endereco;
    private List<StorageUnit> espacos;
    private List<Client> clientes;
    private HashMap<String, List<StorageService>> alugueres;

    public StorageService(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco;
    }

    public boolean registerClient (int taxId, String name, ClientType type) {
        Client cliente = new Client(taxId, name, type);
        return true;
    }

    public void addStorageUnit (StorageUnit storageUnit) {
        espacos.add(storageUnit);
    }

    public void addStorageUnits (Collection<StorageUnit> storageUnits) {
        for (StorageUnit storageUnit : storageUnits) {
            addStorageUnit(storageUnit);
        }
    }

    public boolean rentStorageUnit (Client cliente, StorageUnit espaco, LocalDate dataInicio, int duracao) {
        ClientType tipo = cliente.getTipo();
        return duracao > 90 && tipo == ClientType.ENTERPRISE;
    }
}
