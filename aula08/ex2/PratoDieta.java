package aula08.ex2;

public class PratoDieta extends Prato {
    private double limiteCalorias;

    public PratoDieta(String nome, double limiteCalorias) {
        super(nome);
        this.limiteCalorias = limiteCalorias;
    }

    @Override
    public void adicionarIngrediente(Alimento alimento) {
        if (calcularCalorias() + alimento.getCalorias() > limiteCalorias) {
            System.out.println("ERRO: não é possível adicionar " + alimento.getNome());
        } else {
            super.adicionarIngrediente(alimento);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - Dieta (" + limiteCalorias + " Calorias)";
    }
}
