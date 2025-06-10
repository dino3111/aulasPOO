package treino;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TravelManager {
    private ArrayList<Travel> travels;
    private StandardTravelCostCalculator stcc = new StandardTravelCostCalculator();

    public TravelManager(){
        this.travels = new ArrayList<>();
    }

    public void addTravel(Travel t){
        travels.add(t);
    }

    public void removeTravel(int id){
        for(int i = 0; i<travels.size(); i++){
            if(travels.get(i).getId() == id){
                travels.remove(i);
                break;
            }
        }
    }

    public Travel getTravel(int id){
        for(int i = 0; i<travels.size(); i++){
            if(travels.get(i).getId() == id){
                return travels.get(i);
            }
        }
        return null;
    }

    public double calculateTravelCost(int id){
        for(int i = 0; i<travels.size(); i++){
            if(travels.get(i).getId() == id){
                return stcc.calculateTravelCost(travels.get(i));
            }
        }
        return -1;
    }

    public void printAllTravels(){
        for(int i = 0; i<travels.size(); i++){
            System.out.println(travels.get(i).toString());
        }
    }

    public void sortTravelsByCost(boolean nacional){
        ArrayList<Travel> nacionais = new ArrayList<>();
        ArrayList<Travel> internacionais = new ArrayList<>();

        for(int i = 0; i<travels.size(); i++){
            String[] inicio = travels.get(i).getInicio().split(",");
            String pais_i = inicio[1];

            String[] fim = travels.get(i).getDestino().split(",");
            String pais_f = fim[1];

            if(pais_i.equals(pais_f)){
                nacionais.add(travels.get(i));
            }
            else{
                internacionais.add(travels.get(i));
            }
        }

        if(nacional){
            Collections.sort(nacionais, new Comparator<Travel>(){
                public int compare(Travel v1, Travel v2){
                    double valor_v1 = calculateTravelCost(v1.getId());
                    double valor_v2 = calculateTravelCost(v2.getId());
                    return Double.compare(valor_v2, valor_v1);
                }
            });

            for(int i = 0; i < nacionais.size(); i++){
                System.out.println(nacionais.get(i).toString());
            }
        }
        else{
            Collections.sort(internacionais, new Comparator<Travel>(){
                public int compare(Travel v1, Travel v2){
                    double valor_v1 = calculateTravelCost(v1.getId());
                    double valor_v2 = calculateTravelCost(v2.getId());
                    return Double.compare(valor_v2, valor_v1);
                }
            });

            for(int i = 0; i < internacionais.size(); i++){
                System.out.println(internacionais.get(i).toString());
            }
        }
    }

    public void readFile(String fich){
        try {
            File file = new File(fich);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll("\\s+","");
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int duracao = Integer.parseInt(parts[1]);
                String inicio = parts[2];
                String destino = parts[3];
                Travel t = new Travel(id, duracao, inicio, destino);
                boolean adicionado = false;
                for(int i = 0; i<travels.size(); i++){
                    if(travels.get(i).getId() == id){
                        travels.set(i, t);
                        adicionado = true;
                        break;
                    } 
                }
                if(!adicionado){
                    travels.add(t);
                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void writeFile(String fich){
        try {
            FileWriter myWriter = new FileWriter(fich);
            for(int i = 0; i < travels.size(); i++){
                myWriter.write(travels.get(i).toString() + "preço da viagem =" + stcc.calculateTravelCost(travels.get(i)) + "\n");
            }
            myWriter.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
