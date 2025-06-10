package avaliacaoFinal;


public class EventOccurrence {
    private Place local;
    private String schedule;

    public EventOccurrence(Place local, String schedule) {
        this.local = local;
        this.schedule = schedule;
    }

    public Place getLocal() {
        return this.local;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public String toString() {
        return "Local: " + local + ", Horário e Data: " + schedule;
    }

}
