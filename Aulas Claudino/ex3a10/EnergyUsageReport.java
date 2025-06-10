package ex3a10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class EnergyUsageReport {
    private Map<Integer, Customer> customers;

    public EnergyUsageReport() {
        customers = new HashMap<>();
    }

    public void load(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5) {
                    int id = Integer.parseInt(parts[0]);
                    List<Double> readings = new ArrayList<>();
                    for (int i = 1; i <= 4; i++) {
                        readings.add(Double.parseDouble(parts[i]));
                    }
                    Customer c = new Customer(id, readings);
                    customers.put(id, c);
                }
            }
        }
    }

    public void addCustomer(Customer c) {
        customers.put(c.getCustomerId(), c);
    }

    public void removeCustomer(int id) {
        customers.remove(id);
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    public double calculateTotalUsage(int id) {
        Customer c = customers.get(id);
        if (c != null) {
            return c.getMeterReadings().stream().mapToDouble(Double::doubleValue).sum();
        }
        return 0;
    }

    public void generateReport() {
        System.out.println("Relatório de Consumo de Energia:");
        for (Customer c : customers.values()) {
            double totalUsage = c.getMeterReadings().stream().mapToDouble(Double::doubleValue).sum();
            System.out.println(c.getCustomerId() + " | " + totalUsage);
        }
    }
}
