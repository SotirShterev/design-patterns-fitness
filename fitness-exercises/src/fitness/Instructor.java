package fitness;

import java.util.ArrayList;
import java.util.List;

public class Instructor implements Observable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private List<Observer> observers;

    public Instructor(String name,int age) {
        this.name = name;
        this.age = age;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public void changeTrainingProgramForAll(TrainingProgram trainingProgram, TrainingStrategy strategy,Instructor instructor) {
        trainingProgram.setStrategy(strategy);
        System.out.println("Инструктор " + instructor.name + " промени упражненията на общия режим: " + trainingProgram.getExercises());
        switch (strategy.getClass().getSimpleName())
        {
            case "CardioTrainingStrategy": notifyObservers("Общият режим е променен на кардио");
                break;
            case "StrengthTrainingStrategy" :  notifyObservers("Общият режим е променен на силов");
                break;
            case "YogaDecorator" : notifyObservers("Добавени са йога упражнения към основния режим");
                break;
            case "PilatesDecorator" : notifyObservers("Добавени са пилатес упражнения към основния режим");
                break;
        }
        System.out.println();
    }
}
