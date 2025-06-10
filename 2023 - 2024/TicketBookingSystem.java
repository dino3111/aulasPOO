package avaliacaoFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TicketBookingSystem implements ITicketBookingSystem {
    private HashMap<Integer, ArrayList<Ticket>> bilhetesIDEvento = new HashMap<>();
    private HashMap<String, Event> ocorrenciasEventos = new HashMap<>();
    private ArrayList<Place> locais = new ArrayList<>();
    
    public boolean addEventOccurrence(Event event, Place place, String schedule) {
        String horarioElocal = schedule + ";" + place;
        locais.add(place);
        if (ocorrenciasEventos.containsKey(horarioElocal)) {
            return false;
        } else {
            ocorrenciasEventos.put(horarioElocal, event);
            return true;
        }
    }

    public int bookTickets(int eventId, int numTickets) {
        ArrayList<Ticket> bilhetes = new ArrayList<>(numTickets);
        bilhetesIDEvento.put(eventId, bilhetes);
        Ticket ticket = new Ticket(null, numTickets);
        return ticket.getReferencia();
    }

    public Collection<EventOccurrence> getEventOccurrences() {
        Collection<EventOccurrence> ocorrencias = new ArrayList<>();
        int i = 0;

        for (String chave : ocorrenciasEventos.keySet()) {

            String partes[] = chave.split(";");
            String schedule = partes[0];
            Place place = locais.get(i);
            i++;

            EventOccurrence ocorrencia = new EventOccurrence(place, schedule);
            ocorrencias.add(ocorrencia);
        }
        return ocorrencias;
    }

    public boolean cancelTickets(int ticketReference) {
        for (Integer idEvento : bilhetesIDEvento.keySet()) {
            ArrayList<Ticket> bilhetes = bilhetesIDEvento.get(idEvento);

            for (Ticket ticket : bilhetes) {
                if (ticket.getReferencia() == ticketReference) {
                    return true;
                }
            }
        }
        return false;
    }


}
