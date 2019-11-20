import java.util.ArrayList;

public class DishwasherIsOff implements DishwasherState {
    Dishwasher dishwasher;
    DishwasherProgramEnum programEnum;
    ArrayList<String> possibleCommands = new ArrayList<String>(){
        {
            add("Switch on");
        }
    };

    DishwasherIsOff(Dishwasher newDishwasher) {this.dishwasher = newDishwasher;}

    @Override
    public void switchOn() {
        System.out.println("Hello! Dishwasher is now ON.");
        dishwasher.state = dishwasher.dishwasherIsOn; }

    @Override
    public void chooseProgram(){
        System.out.println("You have to switch on the dishwasher first!"); }

    @Override
    public void startDishwasher(){
        System.out.println("You have to switch on the dishwasher first!"); }

    @Override
    public void checkTimer(){
        System.out.println("You have to switch on the dishwasher first!"); }

    @Override
    public void stopDishwasher(){
        System.out.println("The dishwasher is not even on!"); }

    @Override
    public void switchOff() {
        System.out.println("Dishwasher is already off!"); }

}
