import java.util.*;
import java.util.Scanner;

public class DishwasherIsOn implements DishwasherState {
    private Dishwasher dishwasher;
    DishwasherProgramEnum program;
    private ArrayList<Command> possibleCommands = new ArrayList<Command>();



    // getName() which returns
    // 0 button go back
    DishwasherIsOn(Dishwasher newDishwasher) {
        this.dishwasher = newDishwasher;
        possibleCommands.add(new DishwasherchooseProgramCommand(dishwasher));
        possibleCommands.add(new DishwasherSwitchOffCommand(dishwasher));}

    @Override
    public void killThread() {}

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

    @Override
    public void switchOn() {
        System.out.println("The dishwasher is already ON!");}

    @Override
    public void chooseProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("Which program do you want to chose? \n");
        System.out.println("1) " + DishwasherProgramEnum.GLASSSES + " - " + DishwasherProgramEnum.GLASSSES.getProgramTime() + " mins.");
        System.out.println("2) " + DishwasherProgramEnum.PLATES + " - " + DishwasherProgramEnum.PLATES.getProgramTime() + " mins.");
        System.out.println("3) " + DishwasherProgramEnum.PANS + " - " + DishwasherProgramEnum.PANS.getProgramTime() + " mins.");
        System.out.println("4) " + DishwasherProgramEnum.MIXED + " - " + DishwasherProgramEnum.MIXED.getProgramTime() + " mins.");
        System.out.println("5) " + DishwasherProgramEnum.ECO + " - " + DishwasherProgramEnum.ECO.getProgramTime() + " mins. \n");

        System.out.println("Please enter the program of your choice.");
        while (!validInput) {
            String inputbutton = scanner.next();
            if (inputbutton.matches("[1-5]")) {
                int inputInt =  (Integer.parseInt(inputbutton));
                if (inputInt == 1){ dishwasher.programEnum = DishwasherProgramEnum.GLASSSES;}
                else if(inputInt == 2){ dishwasher.programEnum = DishwasherProgramEnum.PLATES;}
                else if(inputInt == 3){ dishwasher.programEnum = DishwasherProgramEnum.PANS; }
                else if (inputInt == 4) { dishwasher.programEnum = DishwasherProgramEnum.MIXED; }
                else if(inputInt == 5) {dishwasher.programEnum = DishwasherProgramEnum.ECO;}

                dishwasher.programTime = dishwasher.programEnum.getProgramTime()*60;
                dishwasher.program = Integer.parseInt(inputbutton);
                System.out.println("You chose program " + dishwasher.programEnum + ". \nThis program runs for " +
                        dishwasher.programTime/60 + " minutes.");
                dishwasher.state = dishwasher.dishwasherIsSet;
                validInput = true; }

            else { System.out.print("Please enter a program between 1-5."); }
        }
    }


    @Override
    public void startDishwasher() {
            System.out.println("You have to choose a program first in order to start the dishwasher!");}


    @Override
    public void checkTimer() {
        if(dishwasher.programTime == -1){
            System.out.println("Choose a program first!");}
        else{
            System.out.println("Dishwasher's timer is set to " + dishwasher.programTime);}
    }

    @Override
    public void stopDishwasher() { System.out.println("The dishwasher is not even washing!"); }

    @Override
    public void switchOff() {
        System.out.println("Dishwasher is switched off.");
        dishwasher.state = dishwasher.dishwasherIsOff;}

}


