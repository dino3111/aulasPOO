package avaliacaoFinal;

public class Ticket {
    private int referencia;
    private Event eventoAssociado;
    private int numero;
    private static int counter;

    public Ticket(Event eventoAssociado, int numero) {
        this.referencia = counter;
        this.eventoAssociado = eventoAssociado;
        this.numero = numero;
        counter++;
    }

    public int getReferencia() {
        return this.referencia;
    }    

    public Event getEventoassociado() {
        return this.eventoAssociado;
    }

    public int getNumero() {
        return this.numero;
    }

    public String toString() {
        return "Evento: " + eventoAssociado + ", Quantidade: " + numero;
    }
}
