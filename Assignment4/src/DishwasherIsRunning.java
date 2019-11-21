import java.util.ArrayList;

public class DishwasherIsRunning implements DishwasherState {
    private Dishwasher dishwasher;
    ArrayList<Command> possibleCommands = new ArrayList<Command>(){
        {
            add(new DishwasherCheckTimerCommand(dishwasher));
            add(new DishwasherStopDishwasherCommand(dishwasher));
            add(new DishwasherSwitchOffCommand(dishwasher));
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

        //TODO Checktimer does not work!
    @Override
    public void checkTimer(){
        int actualtimer = dishwasher.programTime;
        System.out.println("The dishwasher has finished in " + actualtimer + "minutes"); }

    @Override
    public void switchOff() {
        System.out.println("The dishwaser is swiched off. Goodbye!");
        dishwasher.state = dishwasher.dishwasherIsOff;}

    @Override
    public void stopDishwasher() {
        System.out.println("You stopped the Dishwasher.");
        DishwasherIsSet.killThread();
        dishwasher.state = dishwasher.dishwasherIsSet;
        // in kill thread dishwasher.programTime = dishwasher.programEnum.getProgramTime();}

}}

