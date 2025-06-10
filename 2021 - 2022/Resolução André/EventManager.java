package Exame2122;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EventManager {
    private String nome;
    Set<Client> clientes = new HashSet<>();
    List<Event> eventos = new ArrayList<>();

    public EventManager(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Client addClient(String nome, String localidade) {
        Client x = new Client(nome, localidade);
        clientes.add(x);
        return x;
    }

    public Event addEvent(Client c, LocalDate x) {
        Event evento = new Event(c, x);
        eventos.add(evento);
        return evento;
    }

    public String listClients() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clientes:\n");

        for (Client x : clientes) {
            sb.append(x + "\n");
        }
        return sb.toString();
    }

    public String listEvents() {
        StringBuilder sb = new StringBuilder();
        sb.append("Eventos:\n");
        for (Event x : eventos) {
            sb.append(x + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EventManager)) {
            return false;
        }
        EventManager eventManager = (EventManager) o;
        return Objects.equals(nome, eventManager.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                "}";
    }

    public String[] clientsWithEvents() {
        return null;
    }

    public String[] nextEventsByDate() {
        return null;
    }
}
