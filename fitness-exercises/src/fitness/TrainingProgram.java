package fitness;

import java.util.List;

public class TrainingProgram {
    private TrainingStrategy strategy;

    public void setStrategy(TrainingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> getExercises() {
        return strategy.getExercises();
    }
}
