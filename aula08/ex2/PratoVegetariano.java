package aula08.ex2;

public class PratoVegetariano extends Prato {

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public void adicionarIngrediente(Alimento alimento) {
        if (alimento instanceof Carne || alimento instanceof Peixe) {
            System.out.println("ERRO: não é possível adicionar " + alimento.getNome());
        } else {
            super.adicionarIngrediente(alimento);
        }
    }
}
