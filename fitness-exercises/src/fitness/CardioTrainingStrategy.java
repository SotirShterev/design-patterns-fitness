package fitness;

import java.util.List;

public class CardioTrainingStrategy implements TrainingStrategy{
    @Override
    public List<String> getExercises() {
        return List.of("Скокове от клек", "Бягане по пътека", "Скачане на въже");
    }
}
