package aula10.ex2;

import java.util.List;

public class SimpleAverageCalculator implements IGradeCalculator {

    @Override
    public double calculate(List<Double> grades) {
        if (grades == null || grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

