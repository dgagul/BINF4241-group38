import java.util.*;
import java.util.Scanner;

public class DishwasherIsOn implements DishwasherState {
    Dishwasher dishwasher;
    DishwasherProgramEnum program;
    ArrayList<String> possibleCommands = new ArrayList<String>(){
        {
            add("Choose program");
            add("Switch off");
        }
    };

    DishwasherIsOn(Dishwasher newDishwasher) {
        this.dishwasher = newDishwasher; }

    @Override
    public void switchOn() {
        System.out.println("The dishwasher is already ON!");}

    @Override
    public void chooseProgram(DishwasherProgramEnum program) {
        this.program = program;
        dishwasher.state = dishwasher.dishwasherIsSet;}

    @Override
    public void startDishwasher() {
        System.out.println("You have to choose a program first in order to start the dishwasher!");}

    @Override
    public void checkTimer() {
        System.out.println("Choose a pogram first!");}

    @Override
    public void stopDishwasher() {
        System.out.println("The dishwasher is not even washing!");
    }

    @Override
    public void switchOff() {
        System.out.println("Goodnight.");
        dishwasher.state = dishwasher.dishwasherIsOff;}


    }


