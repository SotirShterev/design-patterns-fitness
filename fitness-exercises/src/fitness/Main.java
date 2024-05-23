package fitness;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Създаване на единствената инстанция на фитнес залата (Singleton)
        FitnessHall fitnessHall = FitnessHall.getInstance();

        // Създаване на инструктори
        Instructor instructor1 = new Instructor("Георги",35);
        Instructor instructor2 = new Instructor("Светозар",40);
        // Задаване на съответния инструктор за залата
        fitnessHall.setInstructor(instructor1);

        // Добавяне на трениращи (Observer)
        Trainee trainee1 = new Trainee("Тодор",25,"75kg");
        Trainee trainee2 = new Trainee("Мария",22,"55kg");
        Trainee trainee3 = new Trainee("Димитър",28,"70kg");
        fitnessHall.addTrainee(trainee1);
        fitnessHall.addTrainee(trainee2);
        fitnessHall.addTrainee(trainee3);

        // Създаване на тренировъчна програма
        TrainingProgram trainingProgram = new TrainingProgram();

        // Инструкторът избира и прилага базова тренировъчна стратегия (Strategy)
        fitnessHall.getInstructor().changeTrainingProgramForAll(trainingProgram, new CardioTrainingStrategy(),fitnessHall.getInstructor());

        // Добавяне на йога упражнения към кардио тренировката чрез Decorator
        fitnessHall.getInstructor().changeTrainingProgramForAll(trainingProgram, new YogaDecorator(new CardioTrainingStrategy(),"Дърво"),fitnessHall.getInstructor());

        // Добавяне на пилатес упражнения към кардио тренировката чрез Decorator
        fitnessHall.getInstructor().changeTrainingProgramForAll(trainingProgram, new PilatesDecorator(new CardioTrainingStrategy(),"Планк"),fitnessHall.getInstructor());

        // Персонализиране на програма за тренировка на 1 трениращ
        trainee1.makePersonalizedTrainingProgram(trainingProgram,new StrengthTrainingStrategy(),trainee1,fitnessHall.getInstructor());

        // Един от трениращите напуска залата
        fitnessHall.removeTrainee(trainee1);

        // Промяна на инструктора на залата
        fitnessHall.setInstructor(instructor2);

        // Новият инструктор сменя базовата стратегия на силова тренировка
        fitnessHall.getInstructor().changeTrainingProgramForAll(trainingProgram, new StrengthTrainingStrategy(),fitnessHall.getInstructor());
    }
}
