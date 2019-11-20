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
    public void chooseProgram(DishwasherProgramEnum programEnum) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.println("Please enter the program (1-5)");
        while(!validInput){
            String inputbutton = scanner.next();
            if (inputbutton.matches("[1-5]")){
                switch(Integer.parseInt(inputbutton)){
                    case 1: dishwasher.programEnum = DishwasherProgramEnum.GLASSSES;
                        break;
                    case 2: dishwasher.programEnum = DishwasherProgramEnum.PLATES;
                        break;
                    case 3: dishwasher.programEnum = DishwasherProgramEnum.PANS;
                        break;
                    case 4: dishwasher.programEnum = DishwasherProgramEnum.MIXED;
                        break;
                    case 5: dishwasher.programEnum = DishwasherProgramEnum.ECO;
                        break;}

                validInput = true;

            }
            else{System.out.print("Please enter a program between 1-5.");}

            dishwasher.programTime = dishwasher.programEnum.getProgramTime();
            dishwasher.program = Integer.parseInt(inputbutton);
            System.out.println("You chose program " + dishwasher.programEnum + ". This program runs for " + dishwasher.programTime
                    +" minutes.");
            dishwasher.state = dishwasher.dishwasherIsSet;}}

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


