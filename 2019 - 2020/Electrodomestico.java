package Teste2020POO;

public class Electrodomestico extends Produto {
    String tipo;
    String marca;
    String modelo;
    double potencia;
    ClasseEnergetica classe;
    double iva = 1.23;

    public Electrodomestico(String tipo, String marca, String modelo, double potencia, double precobase) {
        super("E", 0, precobase);
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public Electrodomestico(String tipo, String marca, String modelo, double precobase) {
        super("E", 0, precobase);
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setClasse(ClasseEnergetica classe) {
        this.classe = classe;
    }

    public double precoVendaAoPublico() {
        return precobase*iva;
    }

    public String getDescricao() {
        return getTipo() + ":" + getMarca()+ "/" + getModelo();
    }

    @Override
    public String toString() {
        return String.format("%s: %10s %d ", getCodigo(), getDescricao(), getStock());
    }

}
