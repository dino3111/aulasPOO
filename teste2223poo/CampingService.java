package teste2223poo;

import java.time.LocalDate;
import java.util.*;

public class CampingService implements StorageServiceInterface{
    private String nome;
    private String endereco;

    private List<CampingSpace> espaços;
    private List<Client> clientes;
    private List<Booking> alugueres;
    
    public CampingService(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.espaços = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alugueres = new ArrayList<>();
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
    public List<CampingSpace> getEspaços() {
        return espaços;
    }
    public void setEspaços(List<CampingSpace> espaços) {
        this.espaços = espaços;
    }
    public List<Client> getClientes() {
        return clientes;
    }
    public void setClientes(List<Client> clientes) {
        this.clientes = clientes;
    }
    public List<Booking> getAlugueres() {
        return alugueres;
    }
    public void setAlugueres(List<Booking> alugueres) {
        this.alugueres = alugueres;
    }

    @Override
    public boolean registerClient(int taxId, String name, ClientType type) {
        for (Client c : clientes) {
            if (c.getTaxId() == taxId) {
                return false;
            }
        }
        Client newClient = new Client(taxId, name, type);
        clientes.add(newClient);
        return true;
    }

    @Override
    public Client getClient(int taxId) {
        for (Client c : clientes) {
            if (c.getTaxId().equals(String.valueOf(taxId))) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void addStorageUnit(StorageUnit storageUnit) {
    }

    @Override
    public void addStorageUnits(Collection<StorageUnit> storageUnits) {
    }

    @Override
    public boolean checkAvailable(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
    }

    @Override
    public List<StorageUnit> findAvailableUnits(UnitType unitType, LocalDate fromDate, int duration,
            int[] minDimensions) {
    }

    @Override
    public boolean rentStorageUnit(Client client, StorageUnit unit, LocalDate startDate, int duration) {
    }

    @Override
    public double calculateTotalCost(StorageUnit unit, int duration) {
    }

    @Override
    public List<String> listRentals() {
    }

    @Override
    public List<String> listRentals(UnitType unitType) {
    }

    
 
}
