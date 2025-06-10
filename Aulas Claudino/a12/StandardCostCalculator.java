package a12;

public class StandardCostCalculator implements IContactCostCalculator {

    @Override
    public double calculateCost(double units, ContactType type) {
        switch (type) {
            case EMAIL:
                return units * 0.10; 
            
            case CELLNUMBER:
                return units * 0.50;
            
            default:
                throw new IllegalArgumentException("Tipo de contacto desconhecido: " + type);
            
        }
    }
}
