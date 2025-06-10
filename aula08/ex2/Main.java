package aula08.ex2;

public class Main {
    public static void main(String[] args) {

        Alimento peixeCongelado = new Peixe("Peixe CONGELADO", 31.3, 25.3, 200, "Congelado");
        Alimento cerealMilho = new Cereal("Cereal Milho", 19.3, 32.4, 110);
        Alimento legumeCouveFlor = new Legume("Legume Couve Flor", 21.3, 22.4, 150);
        Alimento carneFrango = new Carne("Carne FRANGO", 22.3, 345.3, 300, "Frango");
        
        Prato prato1 = new Prato("combinado n.1");
        prato1.adicionarIngrediente(peixeCongelado);
        prato1.adicionarIngrediente(peixeCongelado);
        System.out.println(prato1);

        Prato prato2 = new Prato("combinado n.2");
        prato2.adicionarIngrediente(peixeCongelado);
        prato2.adicionarIngrediente(peixeCongelado);
        System.out.println(prato2);

        PratoVegetariano prato3 = new PratoVegetariano("combinado n.3");
        prato3.adicionarIngrediente(peixeCongelado);  
        prato3.adicionarIngrediente(cerealMilho);
        prato3.adicionarIngrediente(legumeCouveFlor);
        System.out.println(prato3);

        PratoDieta prato4 = new PratoDieta("combinado n.4", 71.28);
        prato4.adicionarIngrediente(cerealMilho);
        prato4.adicionarIngrediente(cerealMilho);
        System.out.println(prato4);

        Ementa ementa = new Ementa("Ementa de Almoço", "Restaurante");
        ementa.adicionarPrato(prato1);
        ementa.adicionarPrato(prato2);
        ementa.adicionarPrato(prato3);
        ementa.adicionarPrato(prato4);

        System.out.println(ementa);
    }
}
