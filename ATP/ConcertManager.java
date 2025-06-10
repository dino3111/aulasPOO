import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class ConcertManager {
    private Map<Integer, Concert> concerts = new HashMap<>();
    private StandardConcertProfitCalculator profitCalculator;

    public void addConcert(Concert c){
        for (Concert existing : concerts.values()) {
            if(existing.getLocal().equalsIgnoreCase(c.getLocal())){
                System.out.println("Concerto já existente.");
                return;
            }
        }
        concerts.put(c.getId(), c);
    }

    public void removeConcert(int id){
        concerts.remove(id);
    }

    public Concert getConcert(int id){
        return concerts.get(id);
    }

    public double calculateConcertProfit(int id){
        Concert c = getConcert(id);
        if (c != null) {
            return profitCalculator.calculateConcertProfit(c);
        } else {
            return -1;
        }
    }

    public void printAllConcerts(){
        for (Concert c : concerts.values()){
            System.out.println(c);
        }
    }

    public void writeFile(String filename){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("ID; Duração; Local; Data e Hora de Início; Lucro");
            for (Concert c : concerts.values()) {
                String line = String.format("%d; %.1f; %s; %s; %.2f",
                    c.getId(),
                    c.getDuracao(),
                    c.getLocal(),
                    c.getDatahorainicio(),
                    concerts.calculateConcertProfit(c));
                pw.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo.");
        }
    }



}
