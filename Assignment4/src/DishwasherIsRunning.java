import java.util.ArrayList;

public class DishwasherIsRunning implements DishwasherState {
    Dishwasher dishwasher;
    ArrayList<String> possibleCommands = new ArrayList<>(){
        {
            add("Check timer");
            add("Stop dishwasher");
            add("Switch off");
        }
    };

    DishwasherIsRunning(Dishwasher newDishwasher){
        this.dishwasher = newDishwasher; }

    @Override
    public void switchOn(){
        System.out.println("The dishwasher is already ON!");}

    @Override
    public void chooseProgram() { System.out.println("The Dishwasher is running at the moment! You can't choose a program now");}

    @Override
    public void startDishwasher() {
        System.out.print("The dishwasher is already running!");}

    @Override
    public void checkTimer(){
        int actualtimer = dishwasher.timer;
        System.out.println("The dishwasher has finished in " + actualtimer + "seconds"); }

    @Override
    public void switchOff() {
        System.out.println("The dishwaser is swiched off. Goodbye!");
        dishwasher.state = dishwasher.dishwasherIsOff;}

    @Override
    public void stopDishwasher() {
        System.out.println("You stopped the Dishwasher.");
        dishwasher.state = dishwasher.dishwasherIsSet; }

}

