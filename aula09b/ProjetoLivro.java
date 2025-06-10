package aula09b;

public class ProjetoLivro {
    public static void main(String[] args){
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];

        p[0] = new Pessoa("Dino", 18, "M");
        p[1] = new Pessoa("Maria", 18, "F");

        l[0] = new Livro("Uma Aventura", "Joaquim Neves", 89, p[0]);
        l[1] = new Livro("The Vampire Diaries", "Elena", 1023, p[1]);
        l[2] = new Livro("POO não é fixe", "UA", 2323, p[0]);

        l[0].abrir();
        l[0].folhear(400);
        System.out.println(l[0].detalhes());
        

    }

}
