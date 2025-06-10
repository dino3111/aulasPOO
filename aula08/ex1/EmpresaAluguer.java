package aula08.ex1;

import java.util.ArrayList;

public class EmpresaAluguer {
    private String nome;
    private String codigoPostal;
    private String email;
    private ArrayList<Viatura> viaturas;

    public EmpresaAluguer(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.viaturas = new ArrayList<>();
    }

    public void adicionarViatura(Viatura viatura) {
        viaturas.add(viatura);
    }

    public Viatura viaturaComMaisQuilometros() {
        Viatura maisKm = viaturas.get(0);
        for (Viatura v : viaturas) {
            if (v.distanciaTotal() > maisKm.distanciaTotal()) {
                maisKm = v;
            }
        }
        return maisKm;
    }

    public Viatura viaturaLigeiraMenosKm() {
        Viatura menosKm = null;
        for (Viatura v : viaturas) {
            if (v instanceof AutomovelLigeiro) {
                if (menosKm == null || v.distanciaTotal() < menosKm.distanciaTotal()) {
                    menosKm = v;
                }
            }
        }
        return menosKm;
    }

    @Override
    public String toString() {
        return "Empresa [nome=" + nome + ", codigoPostal=" + codigoPostal + ", email=" + email + ", viaturas=" + viaturas + "]";
    }
}
