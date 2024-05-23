package fitness;

import java.util.List;

public abstract class TrainingDecorator implements TrainingStrategy{
    protected TrainingStrategy decoratedStrategy;

    public TrainingDecorator(TrainingStrategy strategy) {
        this.decoratedStrategy = strategy;
    }

    @Override
    public List<String> getExercises() {
        return decoratedStrategy.getExercises();
    }
}
