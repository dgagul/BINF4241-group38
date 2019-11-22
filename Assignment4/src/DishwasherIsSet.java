import java.util.ArrayList;
import java.util.Scanner;

public class DishwasherIsSet implements DishwasherState {
    private Dishwasher dishwasher;
    DishwasherProgramEnum dishwasherProgram;
    static long elapsedDishwasher = System.currentTimeMillis();
    private static DishwasherThread washing;
    private static Thread myThreadDishwasher;
    public int programTime1;

    private ArrayList<Command> possibleCommands = new ArrayList<Command>();

    DishwasherIsSet(Dishwasher newDishwasher) {
        this.dishwasher = newDishwasher;
        washing = new DishwasherThread(dishwasher.programTime, dishwasher);
        possibleCommands.add(new DishwasherStartDishwasherCommand(dishwasher));
        possibleCommands.add(new DishwasherchooseProgramCommand(dishwasher));
        possibleCommands.add(new DishwasherCheckTimerCommand(dishwasher));
        possibleCommands.add(new DishwasherSwitchOffCommand(dishwasher));
    }

    @Override
    public void switchOn() {
        System.out.println("The dishwasher is already ON!");}

    @Override
    public void chooseProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.println("Please enter the program (1-5)");
        while (!validInput) {
            String inputbutton = scanner.next();
            if (inputbutton.matches("[1-5]")) {
                int inputInt =  (Integer.parseInt(inputbutton));
                if (inputInt == 1){ dishwasher.programEnum = DishwasherProgramEnum.GLASSSES;}
                else if(inputInt == 2){ dishwasher.programEnum = DishwasherProgramEnum.PLATES;}
                else if(inputInt == 3){ dishwasher.programEnum = DishwasherProgramEnum.PANS; }
                else if (inputInt == 4) { dishwasher.programEnum = DishwasherProgramEnum.MIXED; }
                else if(inputInt == 5) {dishwasher.programEnum = DishwasherProgramEnum.ECO;}

                dishwasher.programTime = dishwasher.programEnum.getProgramTime();
                dishwasher.programTimer = dishwasher.programEnum.getProgramTime();
                dishwasher.program = Integer.parseInt(inputbutton);
                System.out.println("You chose program " + dishwasher.programEnum + ". This program runs for " +
                        dishwasher.programTime/60 + " minutes.");
                dishwasher.state = dishwasher.dishwasherIsSet;
                validInput = true; }

            else { System.out.print("Invalid Input. Please enter a number between 1-5."); }
        }
    }

    @Override
    public void startDishwasher(){
        System.out.println("Dishwasher has started!");
        if (!washing.isRunning()){
            washing = new DishwasherThread(dishwasher.programTimer, dishwasher);
            myThreadDishwasher = new Thread(washing);
            elapsedDishwasher = System.currentTimeMillis();
            myThreadDishwasher.start();
            dishwasher.state = dishwasher.dishwasherIsRunning;} }

    @Override
    public void checkTimer(){
        System.out.println("You chose program" + dishwasher.program + " ) " + dishwasher.programEnum + "and it runs  " + dishwasher.programTime + " minutes");}

    @Override
    public void stopDishwasher() {System.out.println("The dishwasher is not even washing!");}

    @Override
    public void switchOff() {
        System.out.println("Dishwasher is off. Goodnight.");
        dishwasher.state = dishwasher.dishwasherIsOff;}

    @Override
    public void killThread() {myThreadDishwasher.interrupt();
        dishwasher.programTime = dishwasher.programEnum.getProgramTime();}

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

}
