package fitness;

import java.util.ArrayList;
import java.util.List;

public class PilatesDecorator extends TrainingDecorator{
    private String pilates;
    public PilatesDecorator(TrainingStrategy strategy,String pilates) {
        super(strategy);
        this.pilates = pilates;
    }
    @Override
    public List<String> getExercises() {
        List<String> exercises = new ArrayList<>(super.getExercises());
        exercises.add(pilates);
        return exercises;
    }
}
