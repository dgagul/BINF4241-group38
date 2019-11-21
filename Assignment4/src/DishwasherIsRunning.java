import java.util.ArrayList;

public class DishwasherIsRunning implements DishwasherState {
    private Dishwasher dishwasher;
    ArrayList<Command> possibleCommands = new ArrayList<Command>();

    DishwasherIsRunning(Dishwasher newDishwasher){
        this.dishwasher = newDishwasher;
        possibleCommands.add(new DishwasherCheckTimerCommand(dishwasher));
        possibleCommands.add(new DishwasherStopDishwasherCommand(dishwasher));
        possibleCommands.add(new DishwasherSwitchOffCommand(dishwasher));}

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
    public void checkTimer() {
        long timerun = System.currentTimeMillis() - DishwasherIsSet.elapsedDishwasher;
        double time = Math.floor(timerun / 1000);
        dishwasher.programTime = dishwasher.programTime - (int) time;
        DishwasherIsSet.elapsedDishwasher = System.currentTimeMillis();
        System.out.println(dishwasher.programTime/60 + " minutes left.");
    }
    @Override
    public void switchOff() {
        System.out.println("The dishwaser is swiched off. Goodbye!");
        dishwasher.state = dishwasher.dishwasherIsOff;}

    @Override
    public void killThread() {}

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }


    @Override
    public void stopDishwasher() {
        System.out.println("You stopped the Dishwasher.");
        dishwasher.dishwasherIsSet.killThread();
        dishwasher.state = dishwasher.dishwasherIsSet;
        // in kill thread dishwasher.programTime = dishwasher.programEnum.getProgramTime();}

}}

