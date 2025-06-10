package ex1a8;

public class Main {
    public static void main(String[] args) {
        EmpresaAluguer e1 = new EmpresaAluguer("TFM", 3420, "email@email.com");
        AutomovelLigeiro c1 = new AutomovelLigeiro("4112412", "Mercedes", "class a", 2000);
        Motociclo m1 = new Motociclo("29329320", "KAWA", "DKEEKN", 2323);

        e1.add(c1);
        e1.add(m1);

        c1.addKms(160);
        m1.addKms(130);

        System.out.println(e1.maisKms() + "é a viatura com mais km.");


    }

}
