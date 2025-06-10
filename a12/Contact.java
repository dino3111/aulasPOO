package a12;

import java.time.LocalDate;

public class Contact {
    private static int counter = 1; 

    private int id;
    private String nome;
    private int numero;
    private String mail;
    private LocalDate nascimento;

    public Contact(String nome, int numero, String mail, LocalDate nascimento) {
        this.id = counter++;
        this.nome = nome;
        this.numero = numero;
        this.mail = mail;
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public static void setCounter(int value) {
        counter = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + numero + ";" + mail + ";" + nascimento;
    }
}
