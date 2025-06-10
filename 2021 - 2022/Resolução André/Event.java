package Exame2122;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Event implements IEvent {
    private Client cliente;
    private LocalDate data;
    private Set<Activity> atividades = new HashSet<>();

    public Event(Client cliente, LocalDate data) {
        this.cliente = cliente;
        this.data = data;
    }

    public Client getCliente() {
        return this.cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double eventPrice() {
        double contador = 0;
        for (Activity x : atividades) {
            contador += x.getPrice();
        }
        return contador;
    }

    public LocalDate getDate() {
        return data;
    }

    public Event addActivity(Activity activity) {
        atividades.add(activity);
        return this;
    }

    public double getPreco() {
        double preco_final = 0;
        for (Activity x : atividades) {
            preco_final = x.getNumParticipantes() * x.getPrice();
        }
        return preco_final;
    }

    public String getAtividades() {
        StringBuilder sb = new StringBuilder();

        for (Activity x : atividades) {
            sb.append(x + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(cliente, event.cliente) && Objects.equals(data, event.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, data);
    }

    @Override
    public String toString() {
        return getCliente() + "\n" + "*** Evento em " + getData() + ", total=" + getPreco() + " euros\n"
                + getAtividades();
    }
}
