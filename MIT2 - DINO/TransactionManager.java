import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TransactionManager {
    private List<Transaction> transactions;
    private StandardTransactionCostCalculator costCalculator;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
        this.costCalculator = new StandardTransactionCostCalculator();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void removeTransaction(int id) {
        transactions.removeIf(t -> t.getId() == id);
    }

    public Transaction getTransaction(int id) {
        for (Transaction t : transactions) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public double calculateTransactionCost(int id) {
        Transaction t = getTransaction(id);
        if (t != null) {
            return costCalculator.calculateTransactionCost(t);
        } else {
            return -1;
        }
    }

    public void printAllTransactions() {
        transactions.forEach(System.out::println);
    }

    public void sortTransactionsByCost() {
        transactions.sort((t1, t2) -> {
            double cost1 = costCalculator.calculateTransactionCost(t1);
            double cost2 = costCalculator.calculateTransactionCost(t2);
            return Double.compare(cost2, cost1); 
        });
    }

    public void readFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextLine(); 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(";\\s*");
                int id = Integer.parseInt(parts[0]);
                double hoursWorked = Double.parseDouble(parts[1]);
                String description = parts[2];
                String serviceDateTime = parts[3];
                Transaction t = new Transaction(id, hoursWorked, description, serviceDateTime);
                
                boolean exists = false;
                for (int i = 0; i < transactions.size(); i++) {
                    if (transactions.get(i).getId() == id) {
                        transactions.set(i, t);
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    transactions.add(t);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro, ficheiro não encontrado.");
        }
    }

    public void writeFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("ID; Horas Trabalho; Descricao; Data e Hora; Custo");
            for (Transaction t : transactions) {
                String line = String.format("%d; %.1f; %s; %s; %.2f",
                    t.getId(),
                    t.getHoursWorked(),
                    t.getDescription(),
                    t.getServiceDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                    costCalculator.calculateTransactionCost(t));
                writer.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo.");
        }
    }
}