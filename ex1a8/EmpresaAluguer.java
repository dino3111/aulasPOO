package ex1a8;

import java.util.ArrayList;

public class EmpresaAluguer {
    private String nome;
    private int codPostal;
    private String email;
    private ArrayList<Veiculo> garagem;

    public EmpresaAluguer(String nome, int codPostal, String email) {
        this.nome = nome;
        this.codPostal = codPostal;
        this.email = email;
        this.garagem = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodPostal() {
        return codPostal;
    }
    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void add(Veiculo veiculo) {
        garagem.add(veiculo);
    }

    @Override
    public String toString() {
        return "EmpresaAluguer [nome=" + nome + ", codPostal=" + codPostal + ", email=" + email +"]";
    }

    public Veiculo maisKms(){
        Veiculo Viaturamaiskms = null;
        int maxKm = 0;

        for (Veiculo v : garagem){
            int km = v.distanciaTotal();
            if(km > maxKm){
                maxKm = km;
                Viaturamaiskms = v;
            }
        }
        return Viaturamaiskms;
    } 

}
