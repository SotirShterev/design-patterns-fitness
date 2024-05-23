package fitness;

import java.util.ArrayList;
import java.util.List;

public class FitnessHall {
    private static FitnessHall instance = null;
    private Instructor instructor;
    private List<Trainee> trainees;

    private FitnessHall() {
        trainees = new ArrayList<>();
    }

    public static FitnessHall getInstance() {
        if (instance == null) {
            instance = new FitnessHall();
        }
        return instance;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        for (Trainee trainee : trainees) {
            instructor.addObserver(trainee);
        }
        System.out.println(instructor.getName() + " е новият инструктор в залата!" + "\n");
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
        instructor.addObserver(trainee);
        System.out.println(trainee.getName() +  ", добре дошли във фитнес 'Здрав дух в здраво тяло'!" + "\n");
    }

    public void removeTrainee(Trainee trainee) {
        trainees.remove(trainee);
        instructor.removeObserver(trainee);
        System.out.println(trainee.getName() +  ", довиждане, надяваме се да Ви видим отново скоро!" + "\n");
    }

    public void notifyAllTrainees(String message) {
        instructor.notifyObservers(message);
    }
}
