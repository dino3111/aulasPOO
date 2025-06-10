package treino;

public class StandardTravelCostCalculator implements ITravelCostCalculator{
    public StandardTravelCostCalculator(){

    }

    public double calculateTravelCost(Travel t){
        String[] inicio = t.getInicio().split(",");
        String pais_i = inicio[1];

        String[] fim = t.getDestino().split(",");
        String pais_f = fim[1];

        double custo;

        if(pais_i.equals(pais_f)){
            custo = t.getDuracao()*50;
        }
        else{
            custo = t.getDuracao()*150;
        }

        if(t.getDuracao() < 7){
            custo += 75;
        }

        if(t.getId()%10 == 0){
            custo = custo*0.90;
        }

        return custo;
    }
}
