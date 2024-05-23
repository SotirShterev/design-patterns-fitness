package fitness;

import java.util.ArrayList;
import java.util.List;

public class YogaDecorator extends TrainingDecorator{
    private String yoga;
    public YogaDecorator(TrainingStrategy strategy,String yoga) {
        super(strategy);
        this.yoga = yoga;
    }
    @Override
    public List<String> getExercises() {
        List<String> exercises = new ArrayList<>(super.getExercises());
        exercises.add(yoga);
        return exercises;
    }
}
