package fitness;

import java.util.List;

public class StrengthTrainingStrategy implements TrainingStrategy{

    @Override
    public List<String> getExercises() {
        return List.of("Вдигане на тежести", "Клекове", "Лицеви опори");
    }
}
