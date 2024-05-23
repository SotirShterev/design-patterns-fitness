package fitness;

public class Trainee implements Observer {
    private String name;
    private int age;
    private String weight;
    public Trainee(String name,int age,String weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получи съобщение: " + message);
    }

    public void makePersonalizedTrainingProgram(TrainingProgram trainingProgram,TrainingStrategy strategy,Trainee trainee,Instructor instructor)
    {
        trainingProgram.setStrategy(strategy);
        System.out.println("Инструктор " + instructor.getName() + " промени упражненията на " + trainee.getName() + ":" + trainingProgram.getExercises());
        switch (strategy.getClass().getSimpleName())
        {
            case "CardioTrainingStrategy": trainee.update("Вашият режим е променен на кардио");
                break;
            case "StrengthTrainingStrategy" : trainee.update("Вашият режим е променен на силов");
                break;
            case "YogaDecorator" : trainee.update("Добавени са йога упражнения към вашият режим");
                break;
            case "PilatesDecorator" : trainee.update("Добавени са пилатес упражнения към вашият режим");
                break;
        }
        System.out.println();
    }
}
