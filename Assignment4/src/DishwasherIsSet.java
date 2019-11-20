import java.util.ArrayList;
import java.util.Scanner;

public class DishwasherIsSet implements DishwasherState {
    Dishwasher dishwasher;
    DishwasherProgramEnum dishwasherProgram;
    public static long elapsedDishwasher = System.currentTimeMillis();
    public static DishwasherThread washing;
    public static Thread myThreadDishwasher;

    ArrayList<String> possibleCommands = new ArrayList<String>(){
        {
            add("Start dishwasher");
            add("Choose program");
            add("Check timer");
            add("Switch off");
        }
    };

    DishwasherIsSet(Dishwasher newDishwasher) {
        this.dishwasher = newDishwasher;
        washing = new DishwasherThread(dishwasher.timer, dishwasher);
    }

    @Override
    public void switchOn() {
        System.out.println("The dishwasher is already ON!");}

    @Override
    public void chooseProgram(DishwasherProgramEnum program) {
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


    // Todo: thread things with timer
    @Override
    public void startDishwasher(){
        System.out.print("Dishwasher has started");
        dishwasher.state = dishwasher.dishwasherIsRunning;}

    @Override
    public void checkTimer(){
        System.out.println("You chose program " + dishwasher.program + ") " + dishwasher.programEnum + "and it runs" + dishwasher.programTime);}

    @Override
    public void stopDishwasher() {System.out.println("The dishwasher is not even washing!");}

    @Override
    public void switchOff() {
        System.out.println("Dishwasher is off. Goodnight.");
        dishwasher.state = dishwasher.dishwasherIsOff;}


}
