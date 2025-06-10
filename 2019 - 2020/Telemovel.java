package Teste2020POO;
import java.util.HashSet;
import java.util.Set;

public class Telemovel extends Produto{
    String marca;
    String modelo;
    Set<String> notas = new HashSet<>();
    double iva = 1.23;

    public Telemovel(String marca, String modelo, double precobase) {
        super("T", 0, precobase);
        this.marca = marca;
        this.modelo = modelo;
    }

    public double precoVendaAoPublico() {
        return precobase*iva;
    }

    public void addNota(String nota) {
        notas.add(nota);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescricao() {
        return getMarca() + "/" + getModelo();
    }
    
    



}
