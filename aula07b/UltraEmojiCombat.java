package aula07b;

public class UltraEmojiCombat {
    public static void main(String[] args) {
        Lutador l[] = new Lutador[6];

        l[0] = new Lutador("Pretty Boy", "França", 31, 1.75f, 68.9f, null, 11, 2, 1);
        l[1] = new Lutador("Putscript", "Brasil", 29, 1.68f, 57.8f, null, 14, 2, 3);
        l[2] = new Lutador("Snapshadow", "EUA", 35, 1.65f, 80.9f, null, 12, 2, 1);
        l[3] = new Lutador("Dead Code", "Austrália", 28, 1.93f, 81.6f, null, 13, 0, 2);
        l[4] = new Lutador("UFOCobol", "Brasil", 37, 1.70f, 119.3f, null, 5, 4, 3);
        l[5] = new Lutador("Nerdaart", "EUA", 30, 1.81f, 105.7f, null, 12, 2, 4);

        Luta UEC01 = new Luta();
        UEC01.marcarLuta(l[1], l[5]);
        UEC01.lutar();

    }
}
