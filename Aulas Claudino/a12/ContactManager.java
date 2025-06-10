package a12;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ContactManager {

    private Map<Integer, Contact> contacts = new HashMap<>();
    private double totalEmailUnits = 0.0;
    private double totalCallMinutes = 0.0;

    private IContactCostCalculator calculator = new StandardCostCalculator();

    public void addContact(Contact c) {
        for (Contact existing : contacts.values()) {
            if (existing.getMail().equalsIgnoreCase(c.getMail())) {
                System.out.println("Contacto com email já existe.");
                return;
            }
        }
        contacts.put(c.getId(), c);
    }

    public void removeContact(int id) {
        contacts.remove(id);
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    public void sendEmail(int id) {
        if (contacts.containsKey(id)) {
            totalEmailUnits += 1;
        }
    }

    public void call(int id, double minutes) {
        if (contacts.containsKey(id)) {
            totalCallMinutes += minutes;
        }
    }

    public double calculateContactCost() {
        return calculator.calculateCost(totalEmailUnits, IContactCostCalculator.ContactType.EMAIL)
             + calculator.calculateCost(totalCallMinutes, IContactCostCalculator.ContactType.CELLNUMBER);
    }

    public void printAllContacts() {
        for (Contact c : contacts.values()) {
            System.out.println(c);
        }
    }

    public void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 4) {
                    String nome = parts[0];
                    int numero = Integer.parseInt(parts[1]);
                    String mail = parts[2];
                    LocalDate nascimento = LocalDate.parse(parts[3]);
                    Contact c = new Contact(nome, numero, mail, nascimento);
                    addContact(c);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }

    public void writeFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Contact c : contacts.values()) {
                pw.println(c.toString().replace(";", "\t"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever o ficheiro: " + e.getMessage());
        }
    }
}
