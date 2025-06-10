package aula08.ex1;

public class Main {
    public static void main(String[] args) {

        Viatura motociclo = new Motociclo("123ABC", "Honda", "CB500", 50, "desportivo");
        Viatura automovelLigeiro = new AutomovelLigeiro("456DEF", "Toyota", "Corolla", 100, "A123", 450);
        Viatura taxi = new Taxi("789GHI", "Mercedes", "Classe E", 150, "B123", 500, "TX1234");
        Viatura pesadoDeMercadorias = new PesadoDeMercadorias("101JKL", "Volvo", "FMX", 350, "C123", 8000, 15000);
        Viatura pesadoDePassageiros = new PesadoDePassageiros("102JKL", "Scania", "P360", 400, "D123", 10000, 50);
        

        EmpresaAluguer empresa = new EmpresaAluguer("Rent-A-Car", "4200-123", "rent@empresa.com");
        empresa.adicionarViatura(motociclo);
        empresa.adicionarViatura(automovelLigeiro);
        empresa.adicionarViatura(taxi);
        empresa.adicionarViatura(pesadoDeMercadorias);
        empresa.adicionarViatura(pesadoDePassageiros);
        

        Atleta atleta = new Atleta("João");
        

        automovelLigeiro.trajeto(200);
        taxi.trajeto(300);
        atleta.trajeto(10);
        

        Viatura maisKm = empresa.viaturaComMaisQuilometros();
        System.out.println("\nViatura com mais quilómetros: " + maisKm);
        

        Viatura menosKm = empresa.viaturaLigeiraMenosKm();
        System.out.println("\nAutomóvel ligeiro com menos quilómetros: " + menosKm);
        

        System.out.println("\nAtleta - Quilómetros treinados: " + atleta.distanciaTotal());
    }
}
