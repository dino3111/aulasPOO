import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Concert {
    private static int nextId = 1;
    private final int id;
    private double duracao;
    private String local;
    private String datahorainicio;

    public Concert(String local, String datahorainicio, double duracao) {
        this.id = nextId++;
        this.duracao = duracao;
        this.local = local;
        this.datahorainicio = datahorainicio;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Concert [duracao=" + duracao + ", id=" + id + ", local=" + local + ", datahorainicio=" + datahorainicio.formatted(formatter) + "]";
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Concert.nextId = nextId;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDatahorainicio() {
        return datahorainicio;
    }

    public void setDatahorainicio(String datahorainicio) {
        this.datahorainicio = datahorainicio;
    }

}
